package com.example.zdemo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.crypto.HDKeyDerivation;
import org.bitcoinj.crypto.MnemonicCode;
import org.bitcoinj.crypto.MnemonicException;
import org.bitcoinj.wallet.DeterministicSeed;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.ObjectMapperFactory;
import org.web3j.utils.Numeric;

public class Eth {

  public static void createEthWallet(String password) {
    //TODO 密码长度这边校验一下  一般大于8就可以了
    //默认根地址
    String path="m/44'/60'/0'/0/0";
    String[] pathArray =path.split("/");
    long creationTimeSeconds = System.currentTimeMillis() / 1000;
    DeterministicSeed ds = new DeterministicSeed(new SecureRandom(), 128, "", creationTimeSeconds);
    //根私钥
    byte[] seedBytes = ds.getSeedBytes();
    //助记词
    List<String> mnemonic = ds.getMnemonicCode();
    try {
      //助记词种子
      byte[] mnemonicSeedBytes = MnemonicCode.INSTANCE.toEntropy(mnemonic);
      ECKeyPair mnemonicKeyPair = ECKeyPair.create(mnemonicSeedBytes);
      WalletFile walletFile = Wallet.createLight(password, mnemonicKeyPair);
      ObjectMapper objectMapper = ObjectMapperFactory.getObjectMapper();
      //存这个keystore 用完后删除
      String jsonStr = objectMapper.writeValueAsString(walletFile);
      //验证
      WalletFile checkWalletFile = objectMapper.readValue(jsonStr, WalletFile.class);
      ECKeyPair ecKeyPair = Wallet.decrypt(password, checkWalletFile);
      byte[] checkMnemonicSeedBytes = Numeric.hexStringToByteArray(ecKeyPair.getPrivateKey().toString(16));
      List<String> checkMnemonic = MnemonicCode.INSTANCE.toMnemonic(checkMnemonicSeedBytes);

    } catch (MnemonicException.MnemonicLengthException | MnemonicException.MnemonicWordException | MnemonicException.MnemonicChecksumException | CipherException | IOException e) {
      System.out.println("账号生成異常了！！！{}");
    }

    if (seedBytes == null) return;
    DeterministicKey dkKey = HDKeyDerivation.createMasterPrivateKey(seedBytes);
    for (int i = 1; i < pathArray.length; i++) {
      ChildNumber childNumber;
      if (pathArray[i].endsWith("'")) {
        int number = Integer.parseInt(pathArray[i].substring(0,
            pathArray[i].length() - 1));
        childNumber = new ChildNumber(number, true);
      } else {
        int number = Integer.parseInt(pathArray[i]);
        childNumber = new ChildNumber(number, false);
      }
      dkKey = HDKeyDerivation.deriveChildKey(dkKey, childNumber);
    }
    ECKeyPair keyPair = ECKeyPair.create(dkKey.getPrivKeyBytes());
    try {
      WalletFile walletFile = Wallet.createLight(password, keyPair);
      ObjectMapper objectMapper = ObjectMapperFactory.getObjectMapper();
      //keystore
      String jsonStr = objectMapper.writeValueAsString(walletFile);
      System.out.println(jsonStr);
      //私钥
      String privateKey=keyPair.getPrivateKey().toString(16);
      System.out.println(privateKey);
      //公钥
      String publicKey=keyPair.getPublicKey().toString(16);
      System.out.println(publicKey);
      //根地址
      String rpath = dkKey.getPathAsString();
      System.out.println(rpath);
      //地址
      String address="0x" + walletFile.getAddress();
      System.out.println(address);

    } catch (CipherException | JsonProcessingException e) {
      System.out.println("創建账户異常了");
    }
  }

  public static void main(String[] args) {
    createEthWallet("12345678");
  }
}
