package com.tank.spike.pc;

import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Repeat;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

  @Test
  public void testRemaining() {
    val appleUnitPrice = 30;
    val appleAmount = 5;
    val pearUnitPrice = 20;
    val pearAmount = 6;

    val pearRawPrice = new BigDecimal(pearUnitPrice * pearAmount);
    val appleRawPrice = new BigDecimal(appleUnitPrice * appleAmount);
    val amount = appleRawPrice.add(pearRawPrice);

    Assert.assertEquals(amount.intValue(), 270);

    val discountForOrder = new BigDecimal(80);
    val lastPay = amount.subtract(new BigDecimal(80));
    Assert.assertEquals(lastPay.intValue(), 190);

    val appleRation = appleRawPrice.multiply(discountForOrder).divide(amount, 2, RoundingMode.FLOOR);
    val pearRation = pearRawPrice.multiply(discountForOrder).divide(amount, 2, RoundingMode.FLOOR);

    val remaining = discountForOrder.subtract(appleRation).subtract(pearRation);

    val applePay = appleRawPrice.subtract(appleRation);
    val pearPay = pearRawPrice.subtract(pearRation);
    val result = applePay.add(pearPay).add(remaining).intValue();
    Assert.assertEquals(lastPay.intValue(), result);
    System.out.println("xxx");
  }


  private static final ThreadLocalRandom random = ThreadLocalRandom.current();
}