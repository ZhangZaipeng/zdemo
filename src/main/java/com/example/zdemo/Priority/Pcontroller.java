package com.example.zdemo.Priority;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pcontroller {

  @GetMapping("/producer.json")
  public String add(@RequestParam(value = "a") int a) {

    // 组装 order

    // token

    Consumer consumer = new Consumer();
    consumer.setAmount(a);
    ConsumerRunnable c = new ConsumerRunnable(consumer);

    TaskHelper.executePushTask(c);

    return "token";
  }

}
