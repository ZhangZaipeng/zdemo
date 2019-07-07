package com.example.zdemo.Priority;

import com.example.zdemo.Priority.pool.Human;
import com.example.zdemo.Priority.pool.HumanComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TMainTest {

  public static void main(String[] args) {
    List<Human> a = new ArrayList<Human>();
    Human human1 = new Human(0,1000,"张三");
    Human human2 = new Human(1,1000,"李四");
    Human human3 = new Human(2,1000,"王五");
    Human human4 = new Human(3,1000,"赵六");

    a.add(human1);
    a.add(human2);
    a.add(human3);
    a.add(human4);

    for (Human h : a) {
      System.out.println(h.toString());
    }

    Collections.sort(a, new HumanComparator());

    for (Human h : a) {
      System.out.println(h.toString());
    }
  }

}
