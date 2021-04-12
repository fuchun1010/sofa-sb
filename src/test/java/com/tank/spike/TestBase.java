package com.tank.spike;

import com.tank.spike.constants.UrlPrefix;
import lombok.NonNull;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public abstract class TestBase {

  protected MockHttpServletRequestBuilder getReq(@NonNull final String relativeUrl) {
    return MockMvcRequestBuilders.get(UrlPrefix.URL_PREFIX + relativeUrl)
            .accept(MediaType.APPLICATION_JSON);
  }

  protected MockHttpServletRequestBuilder postReq(@NonNull final String relativeUrl) {
    return MockMvcRequestBuilders.post(relativeUrl)
            .accept(MediaType.APPLICATION_JSON);
  }
}
