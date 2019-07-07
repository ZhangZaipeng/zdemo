package com.example.zdemo.Priority.pool;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {

  @Override
  public int compare(Human o1, Human o2) {

    // 订单数量优先
    if (o2.getOrderNum() < o1.getOrderNum()) {
      return 1;
    } else if (o2.getOrderNum() == o1.getOrderNum()) {
      return 0;
    } else {
      return -1;
    }
  }

}
