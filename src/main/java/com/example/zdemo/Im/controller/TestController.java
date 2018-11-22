package com.example.zdemo.Im.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/chat")
@Controller
public class TestController {

  @RequestMapping("/init.htm")
  public ModelAndView init(){
    return new ModelAndView("websocketclient");
  }
}
