package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName: LoggingControllerTest
 * @Description: 对登录Controller的测试
 * @Author lxd
 * @Date 2022/5/19
 * @Version 1.0
 */

@SpringBootTest
public class LoggingControllerTest {
  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  private MockHttpServletRequest request;

  private static final Logger LOGGER = LogManager.getLogger(LoggingControllerTest.class);

  @BeforeEach
  public void before() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();   //指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc
    request = new MockHttpServletRequest();
  }

  /**
   * @Author: lxd
   * @Description: 登录测试
   * @DateTime 2022/5/20 16:00
   * @Params
   */
  @Test
  @DisplayName("登录测试")
  public void testLogging() throws Exception {
    String account = "{\"username\":\"\",\"password\":\"123456\"}";
    String result = mockMvc.perform(post("/verify")
            .content(account)
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn().getResponse().getContentAsString();
    Assertions.assertNotNull(result);
//    将消息体的json数据转换为对象类型
    JSONObject jsonbody = JSON.parseObject(result);
//    获取消息体的状态码
    int code = (int) jsonbody.get("code");
    Assertions.assertTrue(code == 0);
    LOGGER.info(result);

  }

  /**
   * @Author: lxd
   * @Description: 创建账号接口的测试
   * @DateTime 2022/5/19 16:27
   * @Params
   */

  @Test
  public void testRegister() throws Exception {
    String account = "{\"username\":\"zxl\",\"password\":\"123456\"}";
    String result = mockMvc.perform(post("/register")
            .content(account)
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn().getResponse().getContentAsString();
    Assertions.assertNotNull(result);
    //    将消息体的json数据转换为对象类型
    JSONObject jsonbody = JSON.parseObject(result);
//    获取消息体的状态码 0代表成功，1代表失败
    int code = (int) jsonbody.get("code");
    Assertions.assertTrue(code == 0);
  }
}
