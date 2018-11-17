package com.example.zdemo.Priority;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class ProducerRunnable implements Runnable{

  private static final String name = "明刚红李刘吕赵黄王孙朱曾游丽吴昊周郑秦丘";
  private Random random = new Random();
  private PriorityBlockingQueue<Human> queue;

  public ProducerRunnable(PriorityBlockingQueue<Human> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    for(int i = 0; i < 20; i ++){
      Human human = new Human(random.nextInt(10000), "小" + name.charAt(i));
      queue.add(human);
      System.out.println(human + " 开始排队...");
    }
  }

}
