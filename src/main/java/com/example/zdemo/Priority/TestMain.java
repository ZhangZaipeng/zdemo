package com.example.zdemo.Priority;

import java.util.concurrent.PriorityBlockingQueue;

public class TestMain {

  public static void main(String[] args) throws InterruptedException {

    PriorityBlockingQueue<Human> queue = new PriorityBlockingQueue<>(200, new HumanComparator());
    Thread thread = new Thread(new ProducerRunnable(queue));
    thread.start();
    thread.join();
    new Thread(new ConsumerRunnable(queue)).start();
  }

}
