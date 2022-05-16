package com.example.demo.controller;

<<<<<<< HEAD
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName: UserInfoController
 * @Description: 登录页面之后跳转到主页进行渲染的主要逻辑控制层
 * @Author lxd
 * @Date 2022/5/16
 * @Version 1.0
 */

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
  private static final Logger LOGGER = LogManager.getLogger(LoggingController.class);
=======

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
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
  @Autowired
  private UserInfoService userInfoService;

  @RequestMapping("/insert")
<<<<<<< HEAD
  public String insert(@RequestBody UserInfo userInfo) {
    userInfoService.insertUser(userInfo);
    LOGGER.info(userInfo + " 插入数据成功");
    return "插入成功";
  }

  /**
   * @Author: lxd
   * @Description: 通过id查询用户
   * @DateTime 2022/5/16 9:18
   * @Params id
   */
  @RequestMapping("/findById")
  public UserInfo findById(int id) {
=======
  public String insert(UserInfo userInfo){
//    userInfo=new UserInfo(2,"zs",33,"wenhua");
    userInfoService.insertUser(userInfo);
    return "插入成功";
  }

  @RequestMapping("/findById")
  public UserInfo findById(int id){
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283

    return userInfoService.findById(id);
  }

<<<<<<< HEAD
  /**
   * @Author: lxd
   * @Description: 查询用户表里的所有数据，用于登录成功后渲染主页
   * @DateTime 2022/5/16 9:44
   * @Params null
   */
  @RequestMapping("/findAll")
  public String findAll(Model model) {
    List<UserInfo> users = userInfoService.findAll();
    model.addAttribute("users", users);
    return "index";
//    return  userInfoService.findAll(); 最开始接口的测试
  }

  /**
   * @Author: lxd
   * @Description: 更新用户表里的数据
   * @DateTime 2022/5/16 9:45
   * @Params userInfo
   */
  @RequestMapping("/update")
  public String update(@RequestBody UserInfo userInfo) {
=======
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
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
    userInfoService.update(userInfo);
    return "修改成功";
  }

<<<<<<< HEAD
  /**
   * @Author: lxd
   * @Description: 删除用户的数据
   * @DateTime 2022/5/16 9:46
   * @Params userInfo
   */
  @RequestMapping("/delete")
  public String delete(@RequestBody UserInfo userInfo) {
    userInfo = new UserInfo();
=======
  @RequestMapping("/delete")
  public String delete(UserInfo userInfo){
    userInfo=new UserInfo();
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
    userInfo.setId(2);
    userInfoService.delete(userInfo);
    return "删除成功";
  }
}
