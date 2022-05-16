package com.example.demo.dao;

import com.example.demo.entity.Account;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;
=======
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
import org.springframework.stereotype.Repository;

@Repository
public interface LoggingDaoMapper {
  Account selectByUsername(String username);
<<<<<<< HEAD
  int insertAccount(@Param("account") Account account);
  int deleteAccount(@Param("account") Account account);
=======
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
}
