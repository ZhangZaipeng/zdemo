package com.example.zdemo.Priority;

import java.util.concurrent.PriorityBlockingQueue;

public class ConsumerRunnable implements Runnable{

  private PriorityBlockingQueue<Human> queue;

  public ConsumerRunnable(PriorityBlockingQueue<Human> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    while (true){
      Human take = null;
      try {
        take = queue.take();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(take + " 办理业务.");
    }
  }

}
