package com.tank.spike.controller;

import com.alibaba.testable.core.annotation.MockDiagnose;
import com.alibaba.testable.core.annotation.MockMethod;
import com.alibaba.testable.core.matcher.InvokeVerifier;
import com.alibaba.testable.core.model.LogLevel;
import com.alibaba.testable.processor.annotation.EnablePrivateAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tank.spike.TestBase;
import com.tank.spike.constants.UrlPrefix;
import com.tank.spike.entity.User;
import com.tank.spike.mapper.UserMapper;
import com.tank.spike.protocol.resp.ResultApi;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author tank198435163.com
 */
@EnablePrivateAccess
public class UserCtrlTest extends TestBase {


  @MockDiagnose(LogLevel.VERBOSE)
  static class Mock {

    @MockMethod(targetClass = UserMapper.class, targetMethod = "findAll")
    private List<User> mockQueryUsers() {
      val user = new User().setId(1L).setJob("doctor").setGender(1).setUsername("jack");
      return Collections.singletonList(user);
    }

  }

  @Test
  @SneakyThrows
  public void queryAll() {
    val mvcResult = this.mockMvc.perform(super.getReq(UrlPrefix.URL_USERS))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
            .andReturn();
    val json = mvcResult.getResponse().getContentAsString();
    val result = objectMapper.readValue(json, ResultApi.class);
    Assert.assertNotNull(result);
    InvokeVerifier.verify("mockQueryUsers").withTimes(1);
  }

  @Resource
  private MockMvc mockMvc;

  @Resource
  private ObjectMapper objectMapper;


}