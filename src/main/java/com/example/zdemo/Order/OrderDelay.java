package com.example.zdemo.Order;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class OrderDelay implements Delayed {
  private Long orderId;
  private long excuteTime;// 延迟时长 java 时间戳

  public OrderDelay() {
  }

  public OrderDelay(Long orderId, long excuteTime) {
    this.orderId = orderId;
    this.excuteTime = excuteTime;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public long getExcuteTime() {
    return excuteTime;
  }

  public void setExcuteTime(long excuteTime) {
    this.excuteTime = excuteTime;
  }

  @Override
  public long getDelay(TimeUnit unit) {
    return unit.convert(this.excuteTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
  }

  @Override
  public int compareTo(Delayed o) {
    OrderDelay od = (OrderDelay) o;
    return this.orderId > od.getOrderId() ? 1 : this.orderId < od.getOrderId() ? -1 : 0 ;
  }
}
