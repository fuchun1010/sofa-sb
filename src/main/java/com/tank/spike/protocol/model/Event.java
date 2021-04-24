package com.tank.spike.protocol.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @param <T>
 * @author tank198435163.com
 */
@Getter
@Setter
public class Event<T> implements Serializable {

  private T data;
}
