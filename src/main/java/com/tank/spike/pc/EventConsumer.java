package com.tank.spike.pc;


import com.lmax.disruptor.EventHandler;
import com.tank.spike.protocol.model.Event;

/**
 * @param <T>
 * @author tank198435163.com
 */
public class EventConsumer<T> implements EventHandler<Event<T>> {
  @Override
  public void onEvent(Event<T> event, long sequence, boolean endOfBatch) throws Exception {
    System.out.println("event = " + event.getData().toString());
  }
}
