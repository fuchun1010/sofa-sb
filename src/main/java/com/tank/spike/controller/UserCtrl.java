package com.tank.spike.controller;

import com.google.common.collect.Lists;
import com.tank.spike.anno.ResponseWrapper;
import com.tank.spike.anno.Router;
import com.tank.spike.entity.User;
import com.tank.spike.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static com.tank.spike.constants.UrlPrefix.URL_USERS;

/**
 * @author tank198435163.com
 */
@Router("用户路由")
@ResponseWrapper
public class UserCtrl {


  @GetMapping(URL_USERS)
  public List<User> queryAll() {
    return Optional.ofNullable(this.userMapper.findAll()).orElse(Lists.newArrayList());
  }

  @Resource
  private UserMapper userMapper;

}
