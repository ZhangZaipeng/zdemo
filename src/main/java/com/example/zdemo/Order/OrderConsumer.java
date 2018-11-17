package com.example.zdemo.Order;

import java.util.concurrent.DelayQueue;

public class OrderConsumer implements Runnable{

  // 延时队列 ,消费者从其中获取消息进行消费
  private DelayQueue<OrderDelay> queue;

  public OrderConsumer(DelayQueue<OrderDelay> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        OrderDelay take = queue.take();
        System.out.println("消费消息id：" + take.getOrderId());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
