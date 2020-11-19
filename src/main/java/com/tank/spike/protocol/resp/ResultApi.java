package com.tank.spike.protocol.resp;

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
    this.code = 200;
    this.message = "ok";
    this.data = body;
  }

  private int code;

  private String message;

  private T data;


}