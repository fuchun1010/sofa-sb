package com.tank.spike.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author tank198435163.com
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false, of = {"id"})
public class User {

  private Long id;

  private String username;

  private int gender;

  private String job;

}
