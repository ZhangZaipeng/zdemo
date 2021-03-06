package com.example.zdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.example")
//@ServletComponentScan("com.example")
@EnableScheduling
public class ZdemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZdemoApplication.class, args);
  }
}
