package com.tank.spike.protocol.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @param <T>
 * @author tank198435163.com
 */
@Getter
@Setter
public class Event<T> {

  private T data;
}
