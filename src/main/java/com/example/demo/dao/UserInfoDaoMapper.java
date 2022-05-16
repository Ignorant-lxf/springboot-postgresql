package com.example.demo.dao;

import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
<<<<<<< HEAD
public interface UserInfoDaoMapper {
  int insertUser(@Param("userInfo") UserInfo userInfo);

  UserInfo findById(int id);

  List<UserInfo> findAll();

  int updateUser(@Param("userInfo") UserInfo userInfo);

  int deleteUser(@Param("userInfo") UserInfo userInfo);
=======
public interface    UserInfoDaoMapper {
  void insertUser(@Param("userInfo")UserInfo userInfo);
  UserInfo findById(int id);
  List<UserInfo> findAll();
  void updateUser(@Param("userInfo")UserInfo userInfo);
  void deleteUser(@Param("userInfo")UserInfo userInfo);
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
}
