package com.tank.spike.protocol.resp;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.val;

/**
 * @author tank198435163.com
 */
@UtilityClass
public class ResultApiWrapper {

  public <T extends Exception> ResultApi<Void> argumentsError(@NonNull final T illegalArgumentException) {
    val argumentsError = new ResultApi<Void>();
    argumentsError.setCode(400);
    argumentsError.setMessage(illegalArgumentException.getMessage());
    return argumentsError;
  }

  public <T> ResultApi<T> payLoad(@NonNull final T body) {
    return new ResultApi<>(body);
  }

}
