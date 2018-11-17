package com.example.zdemo.Priority;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {

  @Override
  public int compare(Human o1, Human o2) {
    return o2.getManey() - o1.getManey();
  }

}
