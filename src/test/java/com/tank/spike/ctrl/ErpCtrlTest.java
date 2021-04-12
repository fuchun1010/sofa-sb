package com.tank.spike.ctrl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tank.spike.TestBase;
import com.tank.spike.protocol.resp.ResultApi;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.Test;
import org.springframework.test.util.AssertionErrors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static com.tank.spike.constants.UrlPrefix.URL_ACTIVE_MEMBERS;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author tank198435163.com
 */
public class ErpCtrlTest extends TestBase {

  @Test
  @SneakyThrows
  public void obtainActiveMemberTest() {
    AssertionErrors.assertNotNull("objectMapper not allowed empty", objectMapper);
    val mvcResult = this.mockMvc.perform(getReq(URL_ACTIVE_MEMBERS))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
            .andReturn();

    AssertionErrors.assertNotNull("mvnResult Not allowed empty", mvcResult);
    val body = mvcResult.getResponse().getContentAsByteArray();
    val activeMemberResp = this.objectMapper.readValue(new String(body), ResultApi.class);
    AssertionErrors.assertNotNull("activeMemberResp not allowed empty", activeMemberResp);
  }

  @Resource
  private MockMvc mockMvc;

  @Resource
  private ObjectMapper objectMapper;
}
