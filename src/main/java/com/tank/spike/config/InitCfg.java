package com.tank.spike.config;

import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import com.tank.spike.pc.CapacityUtil;
import com.tank.spike.pc.EventConsumer;
import com.tank.spike.pc.EventFactoryDef;
import com.tank.spike.pc.EventProducerDef;
import com.tank.spike.protocol.model.Event;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
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

  @Bean("disruptor")
  public <T> Disruptor<Event<T>> initDisruptor() {
    val ringSize = CapacityUtil.powerSizeFor(1000);
    val eventFactoryDef = new EventFactoryDef<T>();
    val disruptor = new Disruptor<>(
            eventFactoryDef,
            ringSize,
            DaemonThreadFactory.INSTANCE,
            ProducerType.SINGLE,
            new YieldingWaitStrategy()
    );
    disruptor.handleEventsWith(new EventConsumer<T>());
    return disruptor;
  }

  @Bean("producer")
  public <T> EventProducerDef<T> initProducer(@Autowired @Qualifier("disruptor") Disruptor<Event<T>> disruptor) {
    return new EventProducerDef<>(disruptor.getRingBuffer());
  }
}
