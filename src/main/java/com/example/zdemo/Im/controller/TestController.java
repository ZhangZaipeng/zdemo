package com.example.zdemo.Im.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/chat")
public class TestController {

  @RequestMapping("/init.htm")
  public ModelAndView init(){
    return new ModelAndView("wsclient");
  }

  @RequestMapping("/h5.htm")
  public ModelAndView h5init(){
    return new ModelAndView("h5chat");
  }
}
