package com.example.demo;

import com.example.demo.dao.LoggingDaoMapper;
import com.example.demo.entity.Account;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.Md5Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private LoggingDaoMapper loggingDaoMapper;
  private final static Logger LOGGER = LogManager.getLogger(DemoApplicationTests.class);

  /**
   * @Author: lxd
   * @Description: 测试添加用户的功能
   * @DateTime 2022/5/19 9:58
   * @Params null
   */
  @Test
  public void testUserInsert() {
    UserInfo user = new UserInfo(12, "xl", 10, "wh");
    int n = userInfoService.insertUser(user);
    LOGGER.info("测试用户添加功能");
  }

  /**
   * @Author: lxd
   * @Description: 测试用户删除的功能
   * @DateTime 2022/5/19 9:58
   * @Params null
   */
  @Test
  public void testUserDelete() {
    UserInfo userInfo = new UserInfo();
    userInfo.setAge(33);
    int n = userInfoService.delete(userInfo);
    LOGGER.info("测试删除用户的功能 删除了 " + n + " 个用户");
  }

  /**
   * @Author: lxd
   * @Description: 测试md5加密算法
   * @DateTime 2022/5/16 14:12
   * @Params
   */
  @Test
  public void testMd5Code() throws Exception {
    String s = Md5Utils.md5Encode("123456");
    LOGGER.info(s);
//    String s2 = Md5Utils.md5Encode("lxd123.");
//    LOGGER.info(s2);
  }

  /**
   * @Author: lxd
   * @Description: 测试插入用户的功能
   * @DateTime 2022/5/19 9:59
   * @Params
   */
  @Test
  public void testLoggingDaoMapper() throws Exception {
//    Account lxd = new Account("root", "123456");
//    int i = loggingDaoMapper.deleteAccount(lxd);
    String pwd = Md5Utils.md5Encode("admin");
    Account admin = new Account("admin", pwd);
    int n1 = loggingDaoMapper.insertAccount(admin);
//    int n2 = loggingDaoMapper.insertAccount(lxd);
    LOGGER.info(admin);
//    LOGGER.info(pwd2);
  }

  @Test
  public void existAccount() {

  }

  @Test
  void contextLoads() {
  }

}
