package com.example.demo.dao;

import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDaoMapper {
  int insertUser(@Param("userInfo") UserInfo userInfo);

  UserInfo findById(int id);

  List<UserInfo> findAll();

  int updateUser(@Param("userInfo") UserInfo userInfo);

  int deleteUser(@Param("userInfo") UserInfo userInfo);

}
