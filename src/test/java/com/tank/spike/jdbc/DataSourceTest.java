package com.tank.spike.jdbc;

import com.tank.spike.TestBase;
import com.tank.spike.entity.User;
import com.tank.spike.mapper.UserMapper;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tank198435163.com
 */
public class DataSourceTest extends TestBase {

  @Test
  public void testPrintDefinition() {
    Assert.assertNotNull(this.applicationContext);
    val dataSource = applicationContext.getBean("dataSource");
    Assert.assertNotNull(dataSource);
    for (val beanDefinitionName : this.applicationContext.getBeanDefinitionNames()) {
      System.out.println(beanDefinitionName);
    }
    System.out.println(dataSource.getClass().getName());
  }

  @Test
  public void testFindAllUsers() {
    Assert.assertNotNull(this.userMapper);
    List<User> users = this.userMapper.findAll();
    Assert.assertNotNull(users);
    Assert.assertFalse(users.isEmpty());
  }


  @Resource
  private ApplicationContext applicationContext;

  @Resource
  private UserMapper userMapper;
}
