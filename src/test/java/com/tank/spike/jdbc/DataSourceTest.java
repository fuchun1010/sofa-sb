package com.tank.spike.jdbc;

import com.tank.spike.TestBase;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * @author tank198435163.com
 */
public class DataSourceTest extends TestBase {

  @Test
  public void testPrintDefinition() {
    Assert.assertNotNull(this.applicationContext);
    val dataSource = applicationContext.getBean("dataSource");
    Assert.assertNotNull(dataSource);
    System.out.println(dataSource.getClass().getName());
  }

  @Resource
  private ApplicationContext applicationContext;
}
