package com.tank.spike.controller;

import com.google.common.collect.Maps;
import com.tank.spike.anno.Router;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

import static com.tank.spike.constants.UrlPrefix.URL_FOR_GOODS;

/**
 * @author tank198435163.com
 */
@Router("商品类的前端router")
public class GoodsCtrl {

  @GetMapping(URL_FOR_GOODS)
  public ResponseEntity<Map<String, String>> initGoods() {
    val body = Maps.<String, String>newConcurrentMap();
    body.put("s0001", "cq");
    body.put("s0002", "xa");
    return ResponseEntity.ok(body);
  }

}
