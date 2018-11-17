package com.example.zdemo.Priority;

public class Human {
  private String name;
  private int money;

  public Human(int money, String name){
    this.money = money;
    this.name = name;
  }

  public int getManey() {
    return money;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName() + "[存款:"+getManey()+"]";
  }
}
