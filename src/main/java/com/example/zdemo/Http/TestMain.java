package com.example.zdemo.Http;

import java.util.HashMap;
import java.util.Map;

public class TestMain {

  public static void main(String[] args) throws Exception {
    Map<String, Integer> errTry = new HashMap<>();
    Integer a = errTry.remove("1");

    if(a > 0) {
      System.out.println("123");
    }
  }

}
