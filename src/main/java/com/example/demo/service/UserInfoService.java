package com.example.demo.service;

import com.example.demo.entity.UserInfo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserInfoService {
  void insertUser( UserInfo userInfo);
  UserInfo findById(int id);
  List<UserInfo> findAll();
  void update(UserInfo userInfo);
  void delete(UserInfo userInfo);
}
