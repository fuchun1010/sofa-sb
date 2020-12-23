package com.tank.spike.config;

import com.google.common.collect.Maps;
import lombok.NonNull;
import lombok.val;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;
import java.util.function.Predicate;

/**
 * @author tank198435163.com
 */
@Component
public class UrlAnnotationPostProcessor implements BeanPostProcessor, EnvironmentAware {

  @Override
  public void setEnvironment(@NonNull final Environment environment) {
    this.prefixes = Maps.newHashMap();
    this.prefixes.put(environment.getProperty("url.prefix"), s -> true);
  }

  @Override
  public Object postProcessBeforeInitialization(@NonNull final Object bean, @NonNull final String beanName) throws BeansException {
    if (bean instanceof RequestMappingHandlerMapping) {
      val target = ((RequestMappingHandlerMapping) bean);
      target.setPathPrefixes(this.prefixes);
    }
    return bean;
  }

  private Map<String, Predicate<Class<?>>> prefixes = null;


}

