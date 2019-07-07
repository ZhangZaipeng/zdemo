package com.example.zdemo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import io.netty.handler.codec.http.HttpUtil;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.bitcoinj.core.Address;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.DumpedPrivateKey;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionOutPoint;
import org.bitcoinj.core.UTXO;
import org.bitcoinj.core.Utils;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.script.Script;
import org.bitcoinj.wallet.DeterministicSeed;
import org.bitcoinj.wallet.Wallet;
import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Btc {

  //是否主網（default：true）
  public static Boolean isMainNet = true;

  public static Logger logger = LoggerFactory.getLogger(Omni.class);

  /**
   * btc交易签名
   * @param fromAddress
   * @param toAddress
   * @param privateKey
   * @param amount
   * @param fee
   * @param utxos
   * @return
   * @throws Exception
   */
  public static String sign(String fromAddress, String toAddress, String privateKey, long amount, long fee, List<UTXO> utxos) throws Exception {
    NetworkParameters networkParameters = isMainNet ? MainNetParams.get() : TestNet3Params.get();
    Transaction transaction = new Transaction(networkParameters);

    String changeAddress = fromAddress;//找零地址
    Long changeAmount = 0L;
    Long utxoAmount = 0L;
    List<UTXO> needUtxos = new ArrayList<UTXO>();
    //获取未消费列表
    if (utxos == null || utxos.size() == 0) {
      throw new Exception("未消费列表为空");
    }
    //遍历未花费列表，组装合适的item
    for (UTXO utxo : utxos) {
      if (utxoAmount >= (amount + fee)) {
        break;
      } else {
        needUtxos.add(utxo);
        utxoAmount += utxo.getValue().value;
      }
    }
    transaction.addOutput(Coin.valueOf(amount), Address.fromBase58(networkParameters, toAddress));
    //消费列表总金额 - 已经转账的金额 - 手续费 就等于需要返回给自己的金额了
    changeAmount = utxoAmount - (amount + fee);
    //余额判断
    if (changeAmount < 0) {
      throw new Exception("utxo余额不足");
    }
    //输出-转给自己(找零)
    if (changeAmount > 0) {
      transaction.addOutput(Coin.valueOf(changeAmount), Address.fromBase58(networkParameters, changeAddress));
    }
    //输入未消费列表项
    DumpedPrivateKey dumpedPrivateKey = DumpedPrivateKey.fromBase58(networkParameters, privateKey);
    ECKey ecKey = dumpedPrivateKey.getKey();
    for (UTXO utxo : needUtxos) {
      TransactionOutPoint outPoint = new TransactionOutPoint(networkParameters, utxo.getIndex(), utxo.getHash());
      transaction.addSignedInput(outPoint, utxo.getScript(), ecKey, Transaction.SigHash.ALL, true);
    }
    byte[] bytes = transaction.bitcoinSerialize();
    String hash = Hex.toHexString(transaction.bitcoinSerialize());
    logger.info("fee:{},utxoAmount:{},changeAmount{}", fee, utxoAmount, changeAmount);
    return hash;
  }

  /**
   * 获取矿工费用
   * @param amount
   * @param utxos
   * @return
   */
  public static Long getFee(long amount, List<UTXO> utxos) {
    Long feeRate = getFeeRate();//获取费率
    Long utxoAmount = 0L;
    Long fee = 0L;
    Long utxoSize = 0L;
    for (UTXO us : utxos) {
      utxoSize++;
      if (utxoAmount >= (amount + fee)) {
        break;
      } else {
        utxoAmount += us.getValue().value;
        fee = (utxoSize * 148 * 34 * 3 + 10) * feeRate;
      }
    }
    return fee;
  }

  /***
   * 获取未消费列表
   * @param address ：地址
   * @return
   */
  public static List<UTXO> getUnspent(String address) {
    List<UTXO> utxos = Lists.newArrayList();
    String host = isMainNet ? "blockchain.info" : "testnet.blockchain.info";
    String url = "https://" + host + "/zh-cn/unspent?active=" + address;
    try {
      String httpGet = HttpStreamUtil.get(url, null);//TODO;联网
      if ("No free outputs to spend".equals(httpGet)) {
        return utxos;
      }
      JSONObject jsonObject = JSON.parseObject(httpGet);
      JSONArray unspentOutputs = jsonObject.getJSONArray("unspent_outputs");
      List<Map> outputs = JSONObject.parseArray(unspentOutputs.toJSONString(), Map.class);
      if (outputs == null || outputs.size() == 0) {
        System.out.println("交易异常，余额不足");
      }
      for (int i = 0; i < outputs.size(); i++) {
        Map outputsMap = outputs.get(i);
        String tx_hash = outputsMap.get("tx_hash").toString();
        String tx_hash_big_endian = outputsMap.get("tx_hash_big_endian").toString();
        String tx_index = outputsMap.get("tx_index").toString();
        String tx_output_n = outputsMap.get("tx_output_n").toString();
        String script = outputsMap.get("script").toString();
        String value = outputsMap.get("value").toString();
        String value_hex = outputsMap.get("value_hex").toString();
        String confirmations = outputsMap.get("confirmations").toString();
        UTXO utxo = new UTXO(Sha256Hash.wrap(tx_hash_big_endian), Long.valueOf(tx_output_n), Coin.valueOf(Long.valueOf(value)),
            0, false, new Script(Hex.decode(script)));
        utxos.add(utxo);
      }
      return utxos;
    } catch (Exception e) {
      logger.error("【BTC获取未消费列表】失败，", e);
      return null;
    }

  }

  /**
   * 获取btc费率
   *
   * @return
   */
  public static Long getFeeRate() {
    try {
      String httpGet1 = HttpStreamUtil.get("https://bitcoinfees.earn.com/api/v1/fees/recommended", null);
      Map map = JSON.parseObject(httpGet1, Map.class);
      Long fastestFee = Long.valueOf(map.get("fastestFee").toString());
      return fastestFee;
    } catch (Exception e) {
      e.printStackTrace();
      return 0L;
    }
  }

  public static Map createWalletToJson() {
    NetworkParameters networkParameters = true ? MainNetParams.get() : TestNet3Params.get();
    DeterministicSeed seed = new DeterministicSeed(new SecureRandom(), 128, "", Utils.currentTimeSeconds());
    Wallet wallet;
    String mnemonics = "";
    String privateKey = "";
    String publicKey = "";
    String address = "";
    String pwd = "";
    try {
      wallet = Wallet.fromSeed(networkParameters, seed);
      //私钥
      privateKey = wallet.currentReceiveKey().getPrivateKeyAsWiF(networkParameters);
      //助记词
      mnemonics = wallet.getKeyChainSeed().getMnemonicCode().toString();
      publicKey = Hex.toHexString(
          ECKey.publicKeyFromPrivate(wallet.currentReceiveKey().getPrivKey(), true));
      //地址
      address = wallet.currentReceiveAddress().toBase58();
    } catch (Exception e) {
      return null;
    }
    Map resultMap = new LinkedHashMap();
    resultMap.put("mnemonics_K", mnemonics);
    resultMap.put("privateKey_K", privateKey);
    resultMap.put("publicKey_K", publicKey);
    resultMap.put("address_K", address);
    return resultMap;
  }

  public static void main(String[] args) throws Exception{
    // createWalletToJson();
    String from = "1MueAn6g8AU8QVndXeG6G2YRuGK4WtRta8";
    String to = "1J3geU3Jcmyf1soWPtCRZt27ei54w6WRLc";
    String fromPrivate = "KyZ1YYfTsfvw2pUdEnBoNXtX45w5QK2hxJxeQnmqBJLVbMHDD7mu";
    Long amount = 3L;
    List<UTXO> utxos = getUnspent(from);
    Long fee = getFee(amount,utxos);
    String sig = sign(from, to, fromPrivate, amount,fee, utxos);

    System.out.println(sig);
  }

}
