package com.example.zdemo.schedule;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApiController {

  @Autowired
  private ScheduleBao scheduleBao;

  @GetMapping("/test.json")
  @ResponseBody
  public String index1(){
    return "index";
  }

  @GetMapping("/index.htm")
  public ModelAndView index(){
    boolean isRunning = ScheduleBao.isIsRunning() ;
    Map<String, Object> r = new HashMap<String,Object>();
    r.put("isRunning", isRunning);
    return new ModelAndView("index",r);
  }

  @GetMapping("/start.json")
  @ResponseBody
  public String startAndStop(@RequestParam String token, @RequestParam String type){
    if ("1".equals(type)) { // stop
      scheduleBao.setToken(token);
      ScheduleBao.setIsRunning(false);
    } else if ("2".equals(type)) { // start
      scheduleBao.setToken(token);
      ScheduleBao.setIsRunning(true);
    }
    return "ok";
  }
}
