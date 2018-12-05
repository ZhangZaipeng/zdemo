package com.example.zdemo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApiController {

  @Autowired
  private ScheduleBao scheduleBao;

  @GetMapping("/index.htm")
  public ModelAndView index(){
    return new ModelAndView("index");
  }

  @GetMapping("/start.json")
  public String startAndStop(){
    String token = scheduleBao.getToken();
    boolean isRunning = ScheduleBao.isRunning ;
    return "";
  }
}
