package com.tank.spike.compoment;

import com.tank.spike.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * @author tank198435163.com
 */
public class EventPublisherTest extends TestBase {

  @Test
  public void testApplicationContext() {
    Assert.assertNotNull(this.context);
  }

  @Resource
  private ApplicationContext context;
}
