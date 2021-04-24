package com.tank.spike.protocol.item;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class ItemRes implements Serializable {

  private Long weight;
}
