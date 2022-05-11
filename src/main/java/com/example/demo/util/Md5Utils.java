package com.example.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
*@ClassName: Md5Utils
*@Description: 加密的工具类，用于对存储在数据库里面的数据进行加密/解密
*@Author lxd
*@Date 2022/5/16
*@Version 1.0
*
*/
public class Md5Utils {
  public static String md5Encode(String inStr) throws Exception {

    MessageDigest md5 = null;

    try {

      md5 = MessageDigest.getInstance("MD5");

    } catch (Exception e) {

      System.out.println(e.toString());

      e.printStackTrace();

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
