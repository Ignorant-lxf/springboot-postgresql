package com.example.demo.service;

import com.example.demo.dao.UserInfoDaoMapper;
import com.example.demo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
*@ClassName: UserInfoServiceImpl
*@Description: 用户Service层的实现类
*@Author lxd
*@Date 2022/5/20
*@Version 1.0
*
*/
@Component
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired
  private UserInfoDaoMapper userInfoDaoMapper;

  /**
  *@Author: lxd
  *@Description: 增加用户
  *@DateTime 2022/5/20 9:07
  *@Params UserInfo userInfo
  *
  */
  @Transactional
  @Override
  public int insertUser(UserInfo userInfo) {
    return userInfoDaoMapper.insertUser(userInfo);

  }

//  @Override
//  public UserInfo findById(int id) {
//    return userInfoDaoMapper.findById(id);
//  }

  /**
  *@Author: lxd
  *@Description: 查询所有用户信息
  *@DateTime 2022/5/20 9:07
  *@Params null
  *
  */
  @Override
  public List<UserInfo> findAll() {
    return userInfoDaoMapper.findAll();
  }

  /**
  *@Author: lxd
  *@Description: 更新用户信息
  *@DateTime 2022/5/20 9:08
  *@Params UserInfo userInfo
  *
  */
  @Transactional
  @Override
  public int update(UserInfo userInfo) {
    return userInfoDaoMapper.updateUser(userInfo);
  }

  /**
  *@Author: lxd
  *@Description: 删除用户信息
  *@DateTime 2022/5/20 9:08
  *@Params UserInfo userInfo
  *
  */
  @Transactional
  @Override
  public int delete(UserInfo userInfo) {
    return userInfoDaoMapper.deleteUser(userInfo);
  }

}
