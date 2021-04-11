package com.tank.spike.config;

import com.tank.spike.constants.UrlPrefix;
import com.tank.spike.interceptor.CtrlMethodInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author tank198435163.com
 */
@Configuration
public class RouterConfig implements WebMvcConfigurer {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(this.ctrlMethodInterceptor).addPathPatterns(UrlPrefix.URL_PREFIX + "/**");
  }

  @Resource
  private CtrlMethodInterceptor ctrlMethodInterceptor;
}
