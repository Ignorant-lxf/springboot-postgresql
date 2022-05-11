package com.example.demo.controller;


import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@RestController
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
  @Autowired
  private UserInfoService userInfoService;

  @RequestMapping("/insert")
  public String insert(UserInfo userInfo){
//    userInfo=new UserInfo(2,"zs",33,"wenhua");
    userInfoService.insertUser(userInfo);
    return "插入成功";
  }

  @RequestMapping("/findById")
  public UserInfo findById(int id){

    return userInfoService.findById(id);
  }

  //登录之后的数据查询以及页面跳转
  @RequestMapping("/findAll")
  public String findAll(Model model){
    List<UserInfo> users = userInfoService.findAll();
    model.addAttribute("users",users);
    return "index";
//    return  userInfoService.findAll(); 最开始接口的测试
  }
  @RequestMapping("/update")
  public String update(UserInfo userInfo){
    userInfoService.update(userInfo);
    return "修改成功";
  }

  @RequestMapping("/delete")
  public String delete(UserInfo userInfo){
    userInfo=new UserInfo();
    userInfo.setId(2);
    userInfoService.delete(userInfo);
    return "删除成功";
  }
}
