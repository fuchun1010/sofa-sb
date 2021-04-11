package com.tank.spike.interceptor;


import com.google.common.collect.Maps;
import com.tank.spike.anno.ResponseWrapper;
import lombok.val;
import lombok.var;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author tank198435163.com
 */
@Component
public class CtrlMethodInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler) throws Exception {

    if (handler instanceof HandlerMethod) {
      final HandlerMethod handlerMethod = ((HandlerMethod) handler);
      val method = handlerMethod.getMethod();
      var isExists = this.rspAnnotationWrapperCache.containsKey(method);
      if (!isExists) {
        isExists = method.isAnnotationPresent(ResponseWrapper.class);
        isExists |= handlerMethod.getBeanType().isAnnotationPresent(ResponseWrapper.class);
        if (isExists) {
          this.rspAnnotationWrapperCache.putIfAbsent(method, DEFAULT_RESPONSE_FLAG);
        }
      }
      if (isExists) {
        request.setAttribute("ResponseWrapperAnn", DEFAULT_RESPONSE_FLAG);
      }
    }

    return true;
  }

  private static final String DEFAULT_RESPONSE_FLAG = ResponseWrapper.class.getSimpleName();

  private final Map<Method, String> rspAnnotationWrapperCache = Maps.newConcurrentMap();
}
