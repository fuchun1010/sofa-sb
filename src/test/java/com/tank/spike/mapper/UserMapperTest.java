package com.tank.spike.mapper;

import com.tank.spike.TestBase;
import com.tank.spike.entity.User;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author tank198435163.com
 */
public class UserMapperTest extends TestBase {

  @Test
  public void findAll() {
    Assert.assertNotNull(this.userMapper);
    val result = this.userMapper.findAll();
    Assert.assertNotNull(result);
    Assert.assertFalse(result.isEmpty());
  }

  @Test
  public void findBy() {
    val user = new User();
    user.setJob("teacher");
    val result = this.userMapper.findBy(user);
    Assert.assertNotNull(result);
    Assert.assertFalse(result.isEmpty());
  }


  @Resource
  private UserMapper userMapper;
}