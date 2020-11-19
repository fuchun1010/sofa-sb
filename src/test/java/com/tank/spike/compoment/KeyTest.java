package com.tank.spike.compoment;

import com.tank.spike.protocol.model.StoreModel;
import com.tank.spike.protocol.model.TestBase;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author tank198435163.com
 */
public class KeyTest extends TestBase {

  @Test
  public void testInstance() {
    Assert.assertNotNull(this.redisTemplate);
  }

  @Test
  public void testStringKey() {
    val strKey = this.redisTemplate.opsForValue();
    val dateStr = "2020-11-17 17:41:22";
    final List<StoreModel> list = Stream.of("store_1002")
            .map(code -> {
              val model = new StoreModel();
              model.setStoreCode(code);
              model.setDateStr(dateStr);
              return model;
            })
            .toList();
    Assert.assertFalse(list.isEmpty());
    val orderKeys = list.map(StoreModel::ordersKey).toJavaList();
    val value = strKey.multiGet(orderKeys)
            .stream()
            .filter(Objects::nonNull)
            .map(Integer::parseInt)
            .reduce(0, Integer::sum);
    Assert.assertEquals(0, value.compareTo(100));
  }




  @Resource(name = "redisTemplate")
  private RedisTemplate<String, String> redisTemplate;

}
