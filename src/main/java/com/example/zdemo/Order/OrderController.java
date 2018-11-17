package com.example.zdemo.Order;

import java.util.concurrent.DelayQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired
  private OrderContextLib orderContextLib;

  @GetMapping("/ok.json")
  public String test() {

    DelayQueue<OrderDelay> r =  orderContextLib.getOrderDelays();

    OrderDelay o1 = new OrderDelay(2L, 1542360690000L);

    r.add(o1);

    return "ok";
  }

}
