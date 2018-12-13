package com.example.zdemo.utils;

import com.example.zdemo.utils.R.Withdrawals;

public class Applies implements Runnable{
  private Withdrawals w;
  private String token;

  public Applies(Withdrawals w, String token) {
    this.w = w;
    this.token = token;
  }

  @Override
  public void run() {
    R.applies(w,token);
  }
}
