package com.example.demo.controller;


import com.example.demo.entity.Account;
import com.example.demo.service.LoggingService;
import com.example.demo.util.Md5Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: LoggingController
 * @Description: 登录页面的Controller层
 * @Author lxd
 * @Date 2022/5/16
 * @Version 1.0
 */
@CrossOrigin  //和vue访问要添加一个跨域的注解
@Controller
public class LoggingController {

  private static final Logger LOGGER = LogManager.getLogger(LoggingController.class);
  @Autowired
  private LoggingService loggingService;

  /**
   * @Author: lxd
   * @Description: 测试Controller的方法
   * @DateTime 2022/5/16 9:17
   * @Params
   */
  @RequestMapping("/logging")
  public String log() {
    return "logging";
  }

  /**
   * @param account 记录登录的用户名和密码
   * @return json格式数据，交给前端渲染
   */
  @RequestMapping("/verify")

  public String verify(@RequestBody Account account) throws Exception {
    String username = account.getUsername();
    String password = account.getPassword();
    //对密码md5加密和数据库进行判断
    String md5Pwd = Md5Utils.md5Encode(password);

    System.out.println("用户名：" + username + " 密码：" + password);
    Account account1 = loggingService.selectByUsername(username);
    if (account1.getPassword().equals(md5Pwd)) {
      LOGGER.info("用户" + username + " 登录成功");
      return "redirect:/userInfo/findAll";
    } else {
      LOGGER.info("用户 " + username + " 输入的用户名和密码不正确");
      return "error";
    }

  }
}
