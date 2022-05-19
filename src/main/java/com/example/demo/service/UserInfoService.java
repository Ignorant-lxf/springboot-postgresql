package com.example.demo.service;

import com.example.demo.entity.UserInfo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserInfoService {

  int insertUser(UserInfo userInfo);

  //  UserInfo findById(int id);
  List<UserInfo> findAll();

  int update(UserInfo userInfo);

  int delete(UserInfo userInfo);

}
