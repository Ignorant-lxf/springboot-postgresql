package com.example.demo.service;
import com.example.demo.entity.Account;
import org.springframework.stereotype.Service;

/**
*@ClassName: LoggingService
*@Description: 用户登录Service层接口
*@Author lxd
*@Date 2022/5/20
*@Version 1.0
*
*/
@Service
public interface LoggingService {
  //  Account selectByUsername(String username);
  /**
  *@Author: lxd
  *@Description: 查询账号
  *@DateTime 2022/5/20 9:01
  *@Params
  *
  */
  Account selectAccount(Account account);

  /**
  *@Author: lxd
  *@Description: 判断账号是否存在
  *@DateTime 2022/5/20 9:01
  *@Params
  *
  */
  int existAccount(Account account);

  /**
  *@Author: lxd
  *@Description: 新增账号
  *@DateTime 2022/5/20 9:01
  *@Params
  *
  */
  int insertAccount( Account account);
}
