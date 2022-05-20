package com.example.demo.controller;
import com.example.demo.entity.Account;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.LoggingService;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.Md5Utils;
import com.example.demo.entity.returnType.Result;
import com.example.demo.entity.returnType.ResultInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

  @Autowired
  private UserInfoService userInfoService;

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
   * @Responsebody 返回类型为json数据格式时必须加上
   */
  @RequestMapping("/verify")
  @ResponseBody
  public ResultInfo<List<UserInfo>> verify(@RequestBody Account account) throws Exception {
    //校验 验证接收到的参数是否合法
    if (account == null) return Result.Fail("请输入合法参数");

    //逻辑
    String username = account.getUsername();
    String password = account.getPassword();

    //对密码md5加密和数据库进行判断
    String md5Pwd = Md5Utils.md5Encode(password);

    LOGGER.info(account);
//    数据库中实际存在的用户
    Account realAccount = loggingService.selectAccount(account);
    LOGGER.info("数据库中的密码{}",realAccount.getPassword());
    List<UserInfo> users = null;
    if (realAccount.getPassword().equals(md5Pwd)) {
      //返回用户信息，渲染首页
      LOGGER.info("登录成功");
      users = userInfoService.findAll();
      return Result.Ok(users);
    }
    LOGGER.error("登录失败，用户名或密码错误");
    return Result.Fail("用户名或密码错误");
  }

  /**
   * @Author: lxd
   * @Description: 用户注册功能
   * @DateTime 2022/5/19 9:51
   * @Params Account account
   */
  @RequestMapping("/register")
  @ResponseBody
  public ResultInfo register(@RequestBody Account account) {
//    数据健壮性校验
    if (account == null) {
      return Result.Fail("请输入用户名");
    }
    int count = loggingService.existAccount(account);
    if (count > 0) {
      return Result.Fail("账号已存在");
    }
//    插入账号
    int i = loggingService.insertAccount(account);
    if (i <= 0) {
      return Result.Fail("账号创建失败");
    }
    return Result.Ok("账号创建成功");
  }
}

