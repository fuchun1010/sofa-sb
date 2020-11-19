package com.tank.spike.excep;

import com.tank.spike.protocol.resp.ResultApi;
import com.tank.spike.protocol.resp.ResultApiWrapper;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author tank198435163.com
 */
@ControllerAdvice
public class GlobalException {

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ResultApi<Void>> handleArgumentsException(@NonNull final IllegalArgumentException illegalArgumentException) {
    return ResponseEntity.ok(ResultApiWrapper.argumentsError(illegalArgumentException));
  }

}
