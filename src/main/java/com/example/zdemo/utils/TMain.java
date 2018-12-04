package com.example.zdemo.utils;

import com.example.zdemo.utils.R.Content;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class TMain {
  private static Gson gson = new Gson();

  public static void main(String[] args) throws Exception{
    Map<String,String> heads = new HashMap<>();
    heads.put("requestid","5d32b452-de73-458d-b841-8452669c7d20");
    heads.put("x-auth-token","c9d0f652-a8a0-43a7-976c-9e858009cf88");
    heads.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
    heads.put("x-requested-with","XMLHttpRequest");

    Map<String,String> p = new HashMap<>();
    p.put("page","0");
    p.put("size","10");
    p.put("startDate","");
    p.put("endDate","");
    p.put("_=","1543843078935");

    String r = HttpStreamUtil.get("https://www.quanfutong888.com/api/cashier/shopWithdrawals",heads,p,"utf-8");

      Content c = gson.fromJson(r,Content.class);

    /////////////https://www.quanfutong888.com/api/cashier/applies/////
    Map<String,String> p1 = new HashMap<>();
    p1.put("shopWithdrawalId","7c450fbddb197ac11c963a3c1eae4571");
    p1.put("amount","1");
    Gson gson = new Gson();
    String jsonp = gson.toJson(p1);
    System.out.println(jsonp);
    System.out.println(HttpStreamUtil.invokePost("https://www.quanfutong888.com/api/cashier/applies",heads,jsonp));
  }
}
