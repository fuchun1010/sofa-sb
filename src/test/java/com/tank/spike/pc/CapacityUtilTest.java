package com.tank.spike.pc;

import lombok.val;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.springframework.test.annotation.Repeat;

import java.util.concurrent.ThreadLocalRandom;

public class CapacityUtilTest {

  @Test
  @DisplayName("测试1")
  public void testCapacity1() {
    val result = CapacityUtil.powerSizeFor(9);
    Assertions.assertEquals(16, result);
  }

  @Test
  @DisplayName("测试2")
  public void testCapacity2() {
    val result = CapacityUtil.powerSizeFor(16);
    Assertions.assertEquals(16, result);
  }

  @Test
  @DisplayName("测试随机数")
  @Repeat(100)
  public void testRandom() {
    val result = random.nextInt(100);
    System.out.println(result);
    Assertions.assertTrue(result > 1);
  }

  private ThreadLocalRandom random = ThreadLocalRandom.current();
}