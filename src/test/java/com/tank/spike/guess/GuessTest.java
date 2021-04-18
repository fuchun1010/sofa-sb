package com.tank.spike.guess;


import lombok.val;
import org.junit.Assert;
import org.junit.Test;

public class GuessTest {

  @Test
  public void testUploadDir() {
    val path = System.getProperty("user.dir");
    Assert.assertNotNull(path);
    Assert.assertTrue(path.trim().length() > 0);
    System.out.println(path);
  }

}
