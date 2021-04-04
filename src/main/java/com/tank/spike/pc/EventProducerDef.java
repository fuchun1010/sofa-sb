package com.tank.spike.pc;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.tank.spike.protocol.model.Event;
import lombok.NonNull;

/**
 * @param <T>
 * @author tank198435163.com
 */
public class EventProducerDef<T> {

  public EventProducerDef(RingBuffer<Event<T>> ringBuffer) {
    this.ringBuffer = ringBuffer;
  }

  public void sendData(@NonNull final T msg) {
    this.ringBuffer.publishEvent(new EventTranslatorOneArgImpl<T>(), msg);
  }

  private static class EventTranslatorOneArgImpl<T> implements EventTranslatorOneArg<Event<T>, T> {

    @Override
    public void translateTo(Event<T> event, long sequence, T arg0) {
      event.setData(arg0);
    }
  }


  private final RingBuffer<Event<T>> ringBuffer;
}
