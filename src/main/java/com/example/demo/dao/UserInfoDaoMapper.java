package com.example.demo.dao;

import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface    UserInfoDaoMapper {
  void insertUser(@Param("userInfo")UserInfo userInfo);
  UserInfo findById(int id);
  List<UserInfo> findAll();
  void updateUser(@Param("userInfo")UserInfo userInfo);
  void deleteUser(@Param("userInfo")UserInfo userInfo);
}
