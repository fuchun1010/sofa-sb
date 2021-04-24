package com.tank.spike.controller;

import cn.hutool.core.util.ObjectUtil;
import com.tank.spike.anno.Router;
import com.tank.spike.protocol.item.House;
import com.tank.spike.protocol.item.ItemReq;
import com.tank.spike.protocol.item.ItemRes;
import com.tank.spike.protocol.model.Event;
import lombok.NonNull;
import lombok.val;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author tank198435163.com
 */
@Router("商品控制器")
public class GoodCtrl {


  @PostMapping("/copy")
  public ItemRes obtain(@RequestBody @NonNull final ItemReq itemReq) {
    val copy = ObjectUtil.clone(itemReq);
    val event = new Event<House>();
    val house = new House();
    house.setCode("s0001");
    event.setData(house);
    itemReq.getEvents().add(event);
    System.out.println("size = " + copy.getEvents().size());
    return new ItemRes().setWeight(300L);
  }

}
