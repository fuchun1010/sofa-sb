package com.tank.spike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author tank198435163.com
 */
@EnableAspectJAutoProxy
@MapperScan("com.tank.spike.mapper")
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class Main {
  public static void main(final String[] args) {
    SpringApplication.run(Main.class);
  }
}
