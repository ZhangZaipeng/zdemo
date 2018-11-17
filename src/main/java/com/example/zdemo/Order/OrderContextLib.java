package com.example.zdemo.Order;

import com.example.zdemo.Delayed.Message;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class OrderContextLib implements ApplicationListener<ContextRefreshedEvent> {

  // 订单容器
  private DelayQueue<OrderDelay> orderDelays;
  // 消费线程池
  private ExecutorService exec;

  public DelayQueue<OrderDelay> getOrderDelays() {
    return orderDelays;
  }

  // 初始化
  public void init(){
    getDbDateToDelays();
    startConsumer();
  }

  // 往 orderDelays 添加

  // 查询 数据库 初始化 orderDelays
  private void getDbDateToDelays() {
    this.orderDelays = new DelayQueue<>();

    OrderDelay o1 = new OrderDelay(1L, 1542360690000L);
    OrderDelay o2 = new OrderDelay(1L, 1542360695000L);
    OrderDelay o3 = new OrderDelay(1L, 1542360699000L);

    this.orderDelays.add(o1);
    this.orderDelays.add(o2);
    this.orderDelays.add(o3);

  }

  // 启动消费者 消费 orderDelays
  private void startConsumer(){
    this.exec = Executors.newFixedThreadPool(5);
    exec.execute(new OrderConsumer(this.orderDelays));
  }
  // 更改订单 状态

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    init();
  }


}
