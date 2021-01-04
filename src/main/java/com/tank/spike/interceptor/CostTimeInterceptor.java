package com.tank.spike.interceptor;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author tank198435163.com
 */
@Slf4j
@Aspect
@Component
public class CostTimeInterceptor {

  @Around("@annotation(com.tank.spike.anno.CostTime)")
  public Object calculateCostTime(final ProceedingJoinPoint joinPredecessor) {
    final MethodSignature methodSignature = ((MethodSignature) joinPredecessor.getSignature());
    Class<?>[] interfaces = joinPredecessor.getTarget().getClass().getInterfaces();
    Method method = methodSignature.getMethod();
    Object result = null;
    try {
      val start = LocalDateTime.now();
      result = joinPredecessor.proceed();
      val end = LocalDateTime.now();
      val cost = Duration.between(start, end).toMillis();
      log.info(StrUtil.format("{}#{},cost:[{}] 毫秒",
              interfaces[0].getName(),
              method.getName(),
              cost)
      );
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return result;
  }
}
