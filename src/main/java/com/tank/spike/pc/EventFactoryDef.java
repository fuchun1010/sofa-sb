package com.tank.spike.pc;

import com.lmax.disruptor.EventFactory;
import com.tank.spike.protocol.model.Event;
import org.springframework.stereotype.Component;

/**
 * @param <T>
 * @author tank198435163.com
 */
@Component
public class EventFactoryDef<T> implements EventFactory<Event<T>> {
  @Override
  public Event<T> newInstance() {
    return new Event<>();
  }
}
