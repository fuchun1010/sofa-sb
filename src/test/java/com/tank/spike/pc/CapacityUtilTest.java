package com.tank.spike.pc;

import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Repeat;

import java.util.concurrent.ThreadLocalRandom;

public class CapacityUtilTest {

  @Test
  public void testCapacity1() {
    val result = CapacityUtil.powerSizeFor(9);
    Assert.assertEquals(16, result);
  }

  @Test
  public void testCapacity2() {
    val result = CapacityUtil.powerSizeFor(16);
    Assert.assertEquals(16, result);
  }

  @Test
  @Repeat(100)
  public void testRandom() {
    val result = random.nextInt(100);
    System.out.println(result);
    Assert.assertTrue(result > 1);
  }

  private ThreadLocalRandom random = ThreadLocalRandom.current();
}