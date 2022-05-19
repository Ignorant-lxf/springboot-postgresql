package com.example.demo.controller;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.return_type.Result;
import com.example.demo.entity.return_type.ResultInfo;
import com.example.demo.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
  private static final Logger LOGGER = LogManager.getLogger(UserInfoController.class);

  @Autowired
  private UserInfoService userInfoService;

  @RequestMapping("/insert")
  @ResponseBody
  public ResultInfo<List<UserInfo>> insert(@RequestBody UserInfo userInfo) {
    userInfoService.insertUser(userInfo);
    LOGGER.info(userInfo + " 插入数据成功");
    return Result.Ok(userInfoService.findAll());
  }

  /**
   * @Author: lxd
   * @Description: 通过id查询用户
   * @DateTime 2022/5/16 9:18
   * @Params id
   */
//  @RequestMapping("/findById")
//  public UserInfo findById(int id) {
//    return userInfoService.findById(id);
//  }

  /**
   * @Author: lxd
   * @Description: 查询用户表里的所有数据，用于登录成功后渲染主页
   * @DateTime 2022/5/16 9:44
   * @Params null
   */
  @RequestMapping("/findAll")
  @ResponseBody
  public List<UserInfo> findAll() {
    List<UserInfo> users = userInfoService.findAll();
    return users;
  }

  /**
   * @Author: lxd
   * @Description: 更新用户表里的数据
   * @DateTime 2022/5/16 9:45
   * @Params userInfo
   */
  @RequestMapping("/update")
  @ResponseBody
  public ResultInfo<List<UserInfo>> update(@RequestBody UserInfo userInfo) {
    userInfoService.update(userInfo);
    LOGGER.info("修改 " + userInfo + " 的信息");
    return Result.Ok(userInfoService.findAll());
  }


  /**
   * @Author: lxd
   * @Description: 删除用户的数据
   * @DateTime 2022/5/16 9:46
   * @Params userInfo
   */
  @RequestMapping("/delete")
  @ResponseBody
  public ResultInfo<List<UserInfo>> delete(@RequestBody UserInfo userInfo) {
    int n = userInfoService.delete(userInfo);
    LOGGER.info("删除的数量为： " + n);
    return Result.Ok(userInfoService.findAll());
  }
}
