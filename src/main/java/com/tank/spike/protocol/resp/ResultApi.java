package com.tank.spike.protocol.resp;

import com.tank.spike.protocol.code.ResultCode;
import lombok.*;

/**
 * @param <T>
 * @author tank198435163.com
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultApi<T> {

  public ResultApi(@NonNull final T body) {
    this(body, ResultCode.SUCCESS);
  }

  public ResultApi(@NonNull final T body, ResultCode resultCode) {
    this.code = resultCode.getType();
    this.message = resultCode.getMessage();
    this.data = body;
  }

  private int code;

  private String message;

  private T data;


}
