package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoggingController {

  @Autowired
  private LoggingService loggingService;
  @RequestMapping("/logging")
  public String log(){
    return "logging";
  }

  @RequestMapping("/verify")
//  @ResponseBody
  public String verify(String username,String password){
    System.out.println("用户名："+username+" 密码："+password);
    Account account = loggingService.selectByUsername(username);
    if(account.getPassword().equals(password)) {
      return "redirect:/userInfo/findAll";
//      return "index";
    }
    else return "error";
  }

}
