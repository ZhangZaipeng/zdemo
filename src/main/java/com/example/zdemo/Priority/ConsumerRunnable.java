package com.example.zdemo.Priority;

import com.example.zdemo.Priority.pool.Human;
import com.example.zdemo.Priority.pool.HumanComparator;
import com.example.zdemo.Priority.pool.HumanPool;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerRunnable implements Runnable{

  private Logger logger =  LoggerFactory.getLogger(this.getClass());

  private Consumer consumer;

  public ConsumerRunnable(Consumer consumer) {
    this.consumer = consumer;
  }

  @Override
  public void run() {
    Human take = HumanPool.queue.poll();

    // 没有拿到数据
    if (take == null) {
      logger.info("HumanPool 无数据--->");
      return;
    }

    // 拿到数据不符合要求
    int remainAmount = take.getRemainAmount() - consumer.getAmount();


    // name 查找
    // 操作数据库  扣金额 （扣成功 扣失败 网络有异常 ）

    if (new Random().nextInt() % 2 == 0) { // success
      logger.info("操作数据库 ---> 修改成功 ");
      take.setOrderNum(take.getOrderNum() + 1);
      HumanPool.add(take);
    } else {
      logger.info("操作数据库 ---> 修改失败 ");
      HumanPool.add(take);
    }

  }

}
