package com.example.demo;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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


  @BeforeEach
  @DisplayName("Each unit test method is executed once before execution")
  public void before() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();   //指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc
    request = new MockHttpServletRequest();
  }

  @AfterEach
  @DisplayName("Each unit test method is executed once before execution")
  public void after() throws Exception {
  }


  @Test
  @DisplayName("获取用户列表")
  public void testList() throws Exception {
    String account = "{\"username\":\"root\",\"password\":\"123456\"}";
    String result = mockMvc.perform(post("/verify")
            .content(account)
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn().getResponse().getContentAsString();
    Assertions.assertNotNull(result);
  }

  /**
  *@Author: lxd
  *@Description: 创建账号接口的测试
  *@DateTime 2022/5/19 16:27
  *@Params
  *
  */

  @Test
  public void testRegister() throws Exception {
    String account = "{\"username\":\"wy\",\"password\":\"123\"}";
    String result = mockMvc.perform(post("/register")
            .content(account)
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn().getResponse().getContentAsString();
    Assertions.assertNotNull(result);
  }
}