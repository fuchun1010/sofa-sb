package com.tank.spike.interceptor;

import com.tank.spike.protocol.code.ResultCode;
import com.tank.spike.protocol.resp.ResultApi;
import lombok.val;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @author tank198435163.com
 */
@ControllerAdvice
public class RspBodyInterceptor implements ResponseBodyAdvice<Object> {

  @Override
  public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    final ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    val responseWrapperAnn = attributes.getRequest().getAttribute("ResponseWrapperAnn");
    return Objects.nonNull(responseWrapperAnn);
  }

  @Override
  public Object beforeBodyWrite(Object body,
                                MethodParameter returnType,
                                MediaType selectedContentType,
                                Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                ServerHttpRequest request,
                                ServerHttpResponse response) {


    val isError = body instanceof Exception;
    return isError ? new ResultApi<>(body, ResultCode.FAILURE) : new ResultApi<>(body, ResultCode.SUCCESS);

  }
}
