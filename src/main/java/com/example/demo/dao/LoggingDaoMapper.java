package com.example.demo.dao;

import com.example.demo.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggingDaoMapper {
  Account selectByUsername(String username);
  int insertAccount(@Param("account") Account account);
  int deleteAccount(@Param("account") Account account);
}
