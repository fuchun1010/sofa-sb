package com.tank.spike.mapper;

import com.tank.spike.anno.CostTime;
import com.tank.spike.entity.User;
import lombok.NonNull;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

/**
 * @author tank198435163.com
 */
public interface UserMapper {

  @CostTime
  List<User> findAll();

  @CostTime
  List<User> findBy(@NonNull final User user);

  Cursor<User> doFindByJobs(@NonNull final String job);
}
