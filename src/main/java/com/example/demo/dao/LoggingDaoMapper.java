package com.example.demo.dao;

import com.example.demo.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggingDaoMapper {
  Account selectByUsername(String username);
}
