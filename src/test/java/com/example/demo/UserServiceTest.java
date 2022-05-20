package com.example.demo;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @ClassName: UserServiceTest
 * @Description: 测试用户的service层
 * @Author lxd
 * @Date 2022/5/19
 * @Version 1.0
 */
@SpringBootTest
public class UserServiceTest {
  private static final Logger LOGGER = LogManager.getLogger(UserServiceTest.class);
  @Autowired
  UserInfoService userInfoService;

  @Test
  public void testInsertUser() {
    UserInfo user = new UserInfo(14, "test", 99, "beidou");
    int n = userInfoService.insertUser(user);
    Assertions.assertTrue(n == 1);
  }

  @Test
  public void testdeletetUser() {
    UserInfo user = new UserInfo(13, "mytest", 99, "beidou");
    int n = userInfoService.delete(user);
    LOGGER.info(n);
    Assertions.assertTrue(n == 0);
  }

  @Test
  public void testFindAll() {
    List<UserInfo> users = userInfoService.findAll();
    LOGGER.info(users);
  }

  @Test
  public void testUpdate() {
    UserInfo user = new UserInfo(10, "mytest", 99, "beidou");
    int n = userInfoService.update(user);
    LOGGER.info("更新了{}行",n);
    Assertions.assertTrue(n > 0);
  }
}
