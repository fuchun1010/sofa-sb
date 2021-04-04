package com.tank.spike.controller;

import com.tank.spike.anno.Router;
import com.tank.spike.pc.EventProducerDef;
import com.tank.spike.protocol.resp.ResultApi;
import com.tank.spike.protocol.resp.ResultApiWrapper;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.concurrent.ThreadLocalRandom;

import static com.tank.spike.constants.UrlPrefix.URL_FOR_DISRUPTOR;

/**
 * @author tank198435163.com
 */
@Router("disruptor spike")
public class DisruptorCtrl {

  @GetMapping(URL_FOR_DISRUPTOR)
  public ResponseEntity<ResultApi<String>> generate() {
    final ThreadLocalRandom threadLocal = ThreadLocalRandom.current();
    val result = threadLocal.nextInt(100);
    this.eventProducer.sendData(String.valueOf(result));
    return ResponseEntity.ok(ResultApiWrapper.payLoad("ok".toUpperCase()));
  }

  @Resource(name = "producer")
  private EventProducerDef<String> eventProducer;


}
