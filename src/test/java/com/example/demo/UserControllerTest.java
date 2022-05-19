package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

@SpringBootTest
public class UserControllerTest {

  private final static Logger LOGGER = LogManager.getLogger(UserControllerTest.class);

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


  /**
   * @Author: lxd
   * @Description: 测试userController层的findAll(查询所有用户)的方法
   * @DateTime 2022/5/19 15:47
   * @Params
   */
  @Test
  public void testFindAll() throws Exception {
    String result = mockMvc.perform(post("/userInfo/findAll")
    )
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn().getResponse().getContentAsString();
    Assertions.assertNotNull(result);
  }

  /**
   * @Author: lxd
   * @Description: 测试插入用户的功能
   * @DateTime 2022/5/19 15:51
   * @Params
   */
  @Test
  public void testInsert() throws Exception {
    String user = "{\"id\":\"13\",\"name\":\"wy\",\"age\":\"18\",\"addr\":\"wh\"}";
    String result = mockMvc.perform(post("/userInfo/insert")
            .content(user)
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn().getResponse().getContentAsString();
    Assertions.assertNotNull(result);
  }

  /**
   * @Author: lxd
   * @Description: 测试删除用户的功能
   * @DateTime 2022/5/19 15:58
   * @Params
   */

  @Test
  public void testDelete() throws Exception {
    String user = "{\"id\":\"13\",\"name\":\"wy\",\"age\":\"18\",\"addr\":\"wh\"}";
    String result = mockMvc.perform(post("/userInfo/delete")
            .content(user)
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn().getResponse().getContentAsString();
    Assertions.assertNotNull(result);
  }

  /**
   * @Author: lxd
   * @Description: 测试更新用户信息的功能
   * @DateTime 2022/5/19 16:03
   * @Params
   */

  @Test
  public void testUpdate() throws Exception {
    String user = "{\"id\":\"10\",\"name\":\"wy\",\"age\":\"18\",\"addr\":\"wh\"}";
    String result = mockMvc.perform(post("/userInfo/update")
            .content(user)
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn().getResponse().getContentAsString();
    Assertions.assertNotNull(result);
  }
}
