package com.example.demo.service;
import com.example.demo.entity.Account;
import com.example.demo.service.impl.LoggingServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggingServiceTest {
  private static final Logger LOGGER = LogManager.getLogger(LoggingServiceTest.class);
  @Autowired
  LoggingServiceImpl loggingService;

  /**
   * @Author: lxd
   * @Description: 测试查询用户的功能
   * @DateTime 2022/5/19 10:44
   * @Params
   */
  @Test
  public void testSelectUser() {
    Account account = new Account();
    account.setUsername("root");
    account.setPassword("e10adc3949ba59abbe56e057f20f883e");
    Account realAccount = loggingService.selectAccount(account);
    Assertions.assertEquals(account.getUsername(), realAccount.getUsername());
    LOGGER.info("{}-----{}",account.getUsername(),realAccount.getUsername());
    Assertions.assertEquals(account.getPassword(), realAccount.getPassword());
    LOGGER.info("{}------{}",account.getPassword(),realAccount.getPassword());
  }

  @Test
  public void testExistAccount() {
    Account account = new Account();
    account.setUsername("root");
    account.setPassword("e10adc3949ba59abbe56e057f20f883e");
    int n = loggingService.existAccount(account);
    LOGGER.info(n);
    //判断数据库中是否存在该账户
    Assertions.assertTrue(n != 0);
  }
}
