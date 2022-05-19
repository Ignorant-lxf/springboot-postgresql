package com.example.demo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;

/**
 * @ClassName: Md5Utils
 * @Description: 加密的工具类，用于对存储在数据库里面的数据进行加密/解密
 * @Author lxd
 * @Date 2022/5/16
 * @Version 1.0
 */
public class Md5Utils {
  private static final Logger LOGGER = LogManager.getLogger(Md5Utils.class);

  public static String md5Encode(String inStr) throws Exception {

    MessageDigest md5 = null;

    try {

      md5 = MessageDigest.getInstance("MD5");

    } catch (Exception e) {

      LOGGER.error(e);
      return "";

    }

    byte[] byteArray = inStr.getBytes("UTF-8");

    byte[] md5Bytes = md5.digest(byteArray);

    StringBuffer hexValue = new StringBuffer();

    for (int i = 0; i < md5Bytes.length; i++) {

      int val = ((int) md5Bytes[i]) & 0xff;

      if (val < 16) {

        hexValue.append("0");

      }

      hexValue.append(Integer.toHexString(val));

    }

    return hexValue.toString();

  }

}
