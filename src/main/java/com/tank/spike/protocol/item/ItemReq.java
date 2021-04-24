package com.tank.spike.protocol.item;

import com.google.common.collect.Lists;
import com.tank.spike.protocol.model.Event;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author tank198435163.com
 */
@Getter
@Setter
public class ItemReq implements Serializable {

  private String sku;

  private String spu;

  private List<Event<House>> events = Lists.newArrayList();
}
