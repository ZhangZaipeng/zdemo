package com.example.zdemo.Priority.pool;

public class Human {
  // 成交数量
  private int orderNum;
  // 剩余金额
  private int remainAmount;


  // 商家名称
  private String name;

  public Human(int orderNum, int remainAmount, String name) {
    this.orderNum = orderNum;
    this.remainAmount = remainAmount;
    this.name = name;
  }

  public int getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(int orderNum) {
    this.orderNum = orderNum;
  }

  public int getRemainAmount() {
    return remainAmount;
  }

  public void setRemainAmount(int remainAmount) {
    this.remainAmount = remainAmount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"orderNum\":")
        .append(orderNum);
    sb.append(",\"remainAmount\":")
        .append(remainAmount);
    sb.append(",\"name\":\"")
        .append(name).append('\"');
    sb.append('}');
    return sb.toString();
  }
}
