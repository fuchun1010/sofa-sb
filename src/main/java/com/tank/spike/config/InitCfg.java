package com.tank.spike.config;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.validation.constraints.NotNull;

/**
 * @author tank198435163.com
 */
@Configuration
public class InitCfg {

  @Bean("redisTemplate")
  public RedisTemplate<String, Object> initRedisTemplate(@Autowired @NotNull RedisConnectionFactory redisConnectionFactory) {
    val redisTemplate = new RedisTemplate<String, Object>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    StringRedisSerializer serializer = new StringRedisSerializer();
    redisTemplate.setKeySerializer(serializer);
    redisTemplate.setValueSerializer(serializer);
    redisTemplate.setHashKeySerializer(serializer);
    redisTemplate.setHashValueSerializer(serializer);
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

}
