package com.tank.spike.protocol.code;

import lombok.Getter;

/**
 * only indicate response result
 *
 * @author tank198435163.com
 */
public enum ResultCode {

  PARAMETER_ERROR(1000, "参数异常"),
  FAILURE(4000, "失败"),
  SUCCESS(5000, "成功");

  /**
   * @param type
   * @param message
   */
  ResultCode(int type, String message) {
    this.type = type;
    this.message = message;
  }

  /**
   * unique type;
   */
  @Getter
  private int type;

  /**
   * tips for caller
   */
  @Getter
  private String message;
}
