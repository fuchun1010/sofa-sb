package com.tank.spike.config;

import com.lmax.disruptor.dsl.Disruptor;
import com.tank.spike.protocol.model.Event;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * implementation note
 * define some task start when spring ioc started
 */

/**
 * @author tank198435163.com
 */
@Configuration
public class RunnerDef<T> {

  @Bean
  public CommandLineRunner initCommandLineRunner() {
    return args -> {
      this.disruptor.start();
    };
  }


  @Resource(name = "disruptor")
  private Disruptor<Event<T>> disruptor;

}
