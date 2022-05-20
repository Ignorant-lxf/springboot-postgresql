package com.example.demo.service;

import com.example.demo.entity.UserInfo;

import org.springframework.stereotype.Service;

import java.util.List;
/**
*@ClassName: UserInfoService
*@Description: 用户信息的service层
*@Author lxd
*@Date 2022/5/20
*@Version 1.0
*
*/
@Service
public interface UserInfoService {
/**
*@Author: lxd
*@Description: 增加用户
*@DateTime 2022/5/20 9:05
*@Params UserInfo userInfo
*
*/
  int insertUser(UserInfo userInfo);

  //  UserInfo findById(int id);

 /**
 *@Author: lxd
 *@Description: 查询所有的用户信息
 *@DateTime 2022/5/20 9:05
 *@Params null
 *
 */
  List<UserInfo> findAll();

  /**
  *@Author: lxd
  *@Description: 更新用户信息
  *@DateTime 2022/5/20 9:06
  *@Params UserInfo userInfo
  *
  */
  int update(UserInfo userInfo);

  /**
  *@Author: lxd
  *@Description: 删除用户的信息
  *@DateTime 2022/5/20 9:06
  *@Params UserInfo userInfo
  *
  */
  int delete(UserInfo userInfo);

}
