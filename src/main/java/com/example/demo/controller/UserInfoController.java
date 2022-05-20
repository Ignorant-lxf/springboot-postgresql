package com.example.demo.controller;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.returnType.Result;
import com.example.demo.entity.returnType.ResultInfo;
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

  /**
  *@Author: lxd
  *@Description: 插入用户的功能
  *@DateTime 2022/5/20 8:56
  *@Params
  *
  */
  @RequestMapping("/insert")
  @ResponseBody
  public ResultInfo<List<UserInfo>> insert(@RequestBody UserInfo userInfo) {
    int n = userInfoService.insertUser(userInfo);
    if (n<1){
      LOGGER.error("插入数据失败");
      return Result.Fail("插入用户信息失败");
    }
    LOGGER.info("{} 插入数据成功",userInfo);
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
    int update = userInfoService.update(userInfo);
    if (update<1){
      return Result.Fail("信息修改失败");
    }
    LOGGER.info("信息修改成功");
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
    if (n<0){
      LOGGER.error("删除用户信息失败");
      return Result.Fail();
    }
    LOGGER.info("用户信息删除成功");
    return Result.Ok(userInfoService.findAll());
  }
}
