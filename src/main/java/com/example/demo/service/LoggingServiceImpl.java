package com.example.demo.service;

import com.example.demo.dao.LoggingDaoMapper;
import com.example.demo.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggingServiceImpl implements LoggingService {

  @Autowired
  private LoggingDaoMapper loggingDaoMapper;
  @Override
  public Account selectByUsername(String username) {
    return loggingDaoMapper.selectByUsername(username);
  }
}
