package com.tank.spike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

/**
 * @author tank198435163.com
 */
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class Main {
  public static void main(final String[] args) {
    SpringApplication.run(Main.class);
  }
}
