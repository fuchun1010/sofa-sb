package com.tank.spike.jdbc;

import com.tank.spike.TestBase;
import com.tank.spike.entity.User;
import com.tank.spike.interceptor.CostTimeInterceptor;
import com.tank.spike.mapper.UserMapper;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.ibatis.cursor.Cursor;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;

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

  @Test
  public void testCostAnnotation() {
    val costTime = this.applicationContext.getBean(CostTimeInterceptor.class);
    Assert.assertNotNull(costTime);
  }

  @Test
  public void testFindById() {
    val user = new User();
    user.setId(1L);
    List<User> users = userMapper.findBy(user);
    Assert.assertNotNull(users);
    Assert.assertFalse(users.isEmpty());
  }

  @Test
  public void testFindBy() {
    val user = new User();
    user.setJob("teacher");
    List<User> users = userMapper.findBy(user);
    Assert.assertNotNull(users);
    Assert.assertTrue(users.size() > 1);
  }

  @Test
  @SneakyThrows
  public void testCursor() {
    Assert.assertNotNull(this.transactionTemplate);
    this.transactionTemplate.execute(status -> {
      try (Cursor<User> cursor = this.userMapper.doFindByJobs("teacher")) {
        for (User user : cursor) {
          System.out.println(user);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      return null;
    });
  }


  @Resource
  private ApplicationContext applicationContext;

  @Resource
  private UserMapper userMapper;

  @Resource
  private TransactionTemplate transactionTemplate;
}
