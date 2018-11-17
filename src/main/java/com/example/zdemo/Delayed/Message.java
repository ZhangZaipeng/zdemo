package com.example.zdemo.Delayed;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Message implements Delayed{

  private int id;
  private String body; // 消息内容
  private long excuteTime;// 延迟时长，这个是必须的属性因为要按照这个判断延时时长。

  public Message(int id, String body, long excuteTime) {
    this.id = id;
    this.body = body;
    this.excuteTime = excuteTime;
  }

  public int getId() {
    return id;
  }

  public String getBody() {
    return body;
  }

  public long getExcuteTime() {
    return excuteTime;
  }

  // 延迟任务是否到时就是按照这个方法
  // 判断如果返回的是负数, 则说明到期否则还没到期
  @Override
  public long getDelay(TimeUnit unit) {
    return unit.convert(this.excuteTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
  }

  // 自定义比较
  @Override
  public int compareTo(Delayed o) {
    Message msg = (Message) o;
    return Integer.valueOf(this.id) > Integer.valueOf(msg.id) ? 1
        : (Integer.valueOf(this.id) < Integer.valueOf(msg.id) ? -1 : 0);
  }

}
