package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class HelloController {

  @RequestMapping("hello")

  public String hello(){
    return "index";
  }
}
