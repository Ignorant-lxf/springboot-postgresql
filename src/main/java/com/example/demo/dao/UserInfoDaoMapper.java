package com.example.demo.dao;

import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*@ClassName: UserInfoDaoMapper
*@Description: 用户的Dao层
*@Author lxd
*@Date 2022/5/20
*@Version 1.0
*
*/
@Repository
public interface UserInfoDaoMapper {
  /**
  *@Author: lxd
  *@Description: 新增用户
  *@DateTime 2022/5/20 8:58
  *@Params
  *
  */
  int insertUser(@Param("userInfo") UserInfo userInfo);

//  UserInfo findById(int id);

  /**
  *@Author: lxd
  *@Description: 查询所有的用户
  *@DateTime 2022/5/20 8:58
  *@Params
  *
  */
  List<UserInfo> findAll();

  /**
  *@Author: lxd
  *@Description: 更新用户信息
  *@DateTime 2022/5/20 8:58
  *@Params
  *
  */
  int updateUser(@Param("userInfo") UserInfo userInfo);

  /**
  *@Author: lxd
  *@Description: 删除用户信息
  *@DateTime 2022/5/20 8:58
  *@Params
  *
  */
  int deleteUser(@Param("userInfo") UserInfo userInfo);

}
