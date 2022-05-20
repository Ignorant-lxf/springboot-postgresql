package com.example.demo.service.impl;

import com.example.demo.dao.LoggingDaoMapper;
import com.example.demo.entity.Account;
import com.example.demo.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*@ClassName: LoggingServiceImpl
*@Description: 用户登录service层的实现类
*@Author lxd
*@Date 2022/5/20
*@Version 1.0
*
*/
@Service
public class LoggingServiceImpl implements LoggingService {

  @Autowired
  private LoggingDaoMapper loggingDaoMapper;
//  @Override
//  public Account selectByUsername(String username) {
//    return loggingDaoMapper.selectByUsername(username);
//  }

  /**
  *@Author: lxd
  *@Description: 查询账号
  *@DateTime 2022/5/20 9:02
  *@Params
  *
  */
  @Override
  public Account selectAccount(Account account) {
    return loggingDaoMapper.selectAccount(account);
  }

  /**
  *@Author: lxd
  *@Description: 判断账号是否存在
  *@DateTime 2022/5/20 9:02
  *@Params
  *
  */
  @Override
  public int existAccount(Account account) {
    return loggingDaoMapper.existAccount(account);
  }

  /**
  *@Author: lxd
  *@Description: 新增账号
  *@DateTime 2022/5/20 9:02
  *@Params
  *
  */
  @Transactional
  @Override
  public int insertAccount(Account account) {
    return loggingDaoMapper.insertAccount(account);
  }
}
