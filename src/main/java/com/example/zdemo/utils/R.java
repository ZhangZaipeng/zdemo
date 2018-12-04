package com.example.zdemo.utils;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class R {
  private static Gson gson = new Gson();

  private static Logger logger = LoggerFactory.getLogger(R.class);

  public static List<Withdrawals> shopWithdrawals() {
    Map<String,String> heads = new HashMap<>();
    heads.put("x-auth-token","cfd29359-03c5-4f98-b72e-a0510e876bdc");
    heads.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
    heads.put("x-requested-with","XMLHttpRequest");

    Map<String,String> p = new HashMap<>();
    p.put("page","0");
    p.put("size","10");
    p.put("startDate","");
    p.put("endDate","");
    p.put("_=","1543843078935");

    String r = null;
    try {
      r = HttpStreamUtil
          .get("https://www.quanfutong888.com/api/cashier/shopWithdrawals",heads,p,"utf-8");
      logger.info(r);
    } catch (IOException e) {
      e.printStackTrace();
    }

    Content c = gson.fromJson(r,Content.class);

    return c.content;
  }

  public static void applies(Withdrawals w) {
    Map<String,String> heads = new HashMap<>();
    heads.put("x-auth-token","cfd29359-03c5-4f98-b72e-a0510e876bdc");
    heads.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
    heads.put("x-requested-with","XMLHttpRequest");

    if (w != null && w.getTotalWithdrawn() > 0) {
      Map<String,String> p1 = new HashMap<>();
      p1.put("shopWithdrawalId",w.getId());
      p1.put("amount",w.getTotalNotWithdrawn() + "");
      Gson gson = new Gson();
      String jsonp = gson.toJson(p1);
      logger.info(jsonp);
      try {
        logger.info(HttpStreamUtil.invokePost("https://www.quanfutong888.com/api/cashier/applies", heads,jsonp));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  public class Content {
    private List<Withdrawals> content;
  }

  public class Withdrawals{
    private String id;
    private String uniqueNo;
    private int amount;
    private String createTime;
    private int totalWithdrawn;
    private int totalNotWithdrawn;
    private String status;

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getUniqueNo() {
      return uniqueNo;
    }

    public void setUniqueNo(String uniqueNo) {
      this.uniqueNo = uniqueNo;
    }

    public int getAmount() {
      return amount;
    }

    public void setAmount(int amount) {
      this.amount = amount;
    }

    public String getCreateTime() {
      return createTime;
    }

    public void setCreateTime(String createTime) {
      this.createTime = createTime;
    }

    public int getTotalWithdrawn() {
      return totalWithdrawn;
    }

    public void setTotalWithdrawn(int totalWithdrawn) {
      this.totalWithdrawn = totalWithdrawn;
    }

    public int getTotalNotWithdrawn() {
      return totalNotWithdrawn;
    }

    public void setTotalNotWithdrawn(int totalNotWithdrawn) {
      this.totalNotWithdrawn = totalNotWithdrawn;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }
  }
}
