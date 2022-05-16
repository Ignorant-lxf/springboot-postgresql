package com.example.demo.service;

import com.example.demo.entity.UserInfo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserInfoService {
<<<<<<< HEAD
  int insertUser( UserInfo userInfo);
  UserInfo findById(int id);
  List<UserInfo> findAll();
  int update(UserInfo userInfo);
  int delete(UserInfo userInfo);
=======
  void insertUser( UserInfo userInfo);
  UserInfo findById(int id);
  List<UserInfo> findAll();
  void update(UserInfo userInfo);
  void delete(UserInfo userInfo);
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
}
