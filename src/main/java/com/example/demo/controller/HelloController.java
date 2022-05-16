package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283

@Controller
@RequestMapping("/demo")
public class HelloController {

  @RequestMapping("hello")
<<<<<<< HEAD
  public String hello() {
=======
  public String hello(){
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
    return "index";
  }
}
