package com.tank.spike.pc;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

/**
 * @author tank198435163.com
 */
@UtilityClass
public class CapacityUtil {

  @SneakyThrows
  public int powerSizeFor(@NonNull final Integer cap) {
    if (cap < 0) {
      throw new IllegalAccessException();
    }
    int result = cap - 1;
    result |= result >>> 1;
    result |= result >>> 2;
    result |= result >>> 4;
    result |= result >>> 8;
    result |= result >>> 16;

    if (result < 0) {
      return 1;
    }

    return result >= MAX_CAP ? MAX_CAP : result + 1;

  }

  private final int MAX_CAP = 1 << 30;
}
