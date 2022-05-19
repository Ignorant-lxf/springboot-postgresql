package com.example.demo.dao;

import com.example.demo.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggingDaoMapper {
  /**
   * @Author: lxd
   * @Description: 根据账户名查询密码
   * @DateTime 2022/5/19 9:55
   * @Params String username
   */
  Account selectByUsername(String username);

  /**
   * @Author: lxd
   * @Description: 增加账户
   * @DateTime 2022/5/19 9:55
   * @Params Account account
   */
  int insertAccount(@Param("account") Account account);

  /**
   * @Author: lxd
   * @Description: 删除账户
   * @DateTime 2022/5/19 9:55
   * @Params Account account
   */
  int deleteAccount(@Param("account") Account account);

  /**
   * @Author: lxd
   * @Description: 查询账户
   * @DateTime 2022/5/19 9:56
   * @Params Account account
   */
  Account selectAccount(@Param("account") Account account);

  /**
   * @Author: lxd
   * @Description: 注册之前判断是否存在账户
   * @DateTime 2022/5/19 9:56
   * @Params Account account
   */
  int existAccount(@Param("account") Account account);
}
