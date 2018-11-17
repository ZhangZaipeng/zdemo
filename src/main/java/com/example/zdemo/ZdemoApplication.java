package com.example.zdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class ZdemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZdemoApplication.class, args);
  }
}
