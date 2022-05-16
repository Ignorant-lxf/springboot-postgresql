package com.example.demo;

<<<<<<< HEAD
import com.example.demo.dao.LoggingDaoMapper;
import com.example.demo.entity.Account;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.Md5Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.junit.jupiter.api.Test;
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

<<<<<<< HEAD
  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private LoggingDaoMapper loggingDaoMapper;
  private final static Logger LOGGER=LogManager.getLogger(DemoApplicationTests.class);
  @Test
  public void testUserInsert(){
    UserInfo user = new UserInfo(11,"lxh",50,"wh");
    int n = userInfoService.insertUser(user);
    System.out.println("插入后的n值为"+ n);

    LOGGER.info("测试用户添加功能");
  }

  @Test
  public void testUserDelete(){
    UserInfo userInfo = new UserInfo();
    userInfo.setAge(18);
    int n = userInfoService.delete(userInfo);
    LOGGER.info("测试删除用户的功能 删除了 "+ n+" 个用户");
  }

  /**
  *@Author: lxd
  *@Description: 测试md5加密算法
  *@DateTime 2022/5/16 14:12
  *@Params
  *
  */
  @Test
  public void testMd5Code() throws Exception {
    String s = Md5Utils.md5Encode("lxd123.");
    LOGGER.info(s);
    String s2 = Md5Utils.md5Encode("lxd123.");
    LOGGER.info(s2);
    System.out.println(s.equals(s2));
  }

  @Test
  public void testLoggingDaoMapper() throws Exception {
//    Account lxd = new Account("root", "123456");
//    int i = loggingDaoMapper.deleteAccount(lxd);
    String pwd = Md5Utils.md5Encode("123456");
    String pwd2 = Md5Utils.md5Encode("123");
    Account root = new Account("root", pwd);
    Account lxd = new Account("lxd", pwd2);
//    int n1 = loggingDaoMapper.insertAccount(root);
//    int n2 = loggingDaoMapper.insertAccount(lxd);
    LOGGER.info(pwd);
    LOGGER.info(pwd2);
  }
=======
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
  @Test
  void contextLoads() {
  }

}
