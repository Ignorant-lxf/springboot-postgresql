package com.example.demo.service;

import com.example.demo.dao.UserInfoDaoMapper;
import com.example.demo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired
  private UserInfoDaoMapper userInfoDaoMapper;
  @Override
  public void insertUser(UserInfo userInfo) {
    userInfoDaoMapper.insertUser(userInfo);
  }

  @Override
  public UserInfo findById(int id) {
    return userInfoDaoMapper.findById(id);
  }

  @Override
  public List<UserInfo> findAll() {
    return userInfoDaoMapper.findAll();
  }

  @Override
  public void update(UserInfo userInfo) {
    userInfoDaoMapper.updateUser(userInfo);
  }

  @Override
  public void delete(UserInfo userInfo) {
    userInfoDaoMapper.deleteUser(userInfo);
  }
}