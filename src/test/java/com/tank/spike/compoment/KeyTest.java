package com.tank.spike.compoment;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Sets;
import com.tank.spike.protocol.model.StoreModel;
import com.tank.spike.protocol.model.TestBase;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            .map(Object::toString)
            .map(Integer::parseInt)
            .reduce(0, Integer::sum);
    Assert.assertEquals(0, value.compareTo(100));
  }


  @Test
  public void testSweetMember() {
    val scoreSet = this.redisTemplate.opsForZSet();
    val startDate = LocalDate.now().plusDays(-30);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePattern.NORM_DATE_PATTERN);
    val stores = IntStream.rangeClosed(1, 30)
            .boxed()
            .map(day -> {
              val date = startDate.plusDays(day);
              return dateTimeFormatter.format(date);
            })
            .map(date -> StrUtil.format("{}:{}:sw", date, storeCode))
            .collect(Collectors.toList());

    //stores.stream().forEach(System.out::println);

    val existedKeys = Stream.ofAll(stores).filter(this.redisTemplate::hasKey).toJavaList();
    val sweetMembers = Sets.<Object>newHashSet();
    for (String existedKey : existedKeys) {
      sweetMembers.addAll(scoreSet.rangeByScore(existedKey, 0, Double.MAX_VALUE));
    }
    sweetMembers.stream().forEach(System.out::println);

  }

  @Test
  public void testSweetMember2() {

    this.redisTemplate.execute(new RedisCallback<Object>() {
      @Override
      public Object doInRedis(RedisConnection connection) throws DataAccessException {
        val value = connection.zSetCommands().zCount("testz".getBytes(), 0, 1000);
        Assert.assertTrue(value == 1);
        return connection.closePipeline();
      }
    });

  }


  @Resource(name = "redisTemplate")
  private RedisTemplate<String, Object> redisTemplate;

  private String storeCode = "1002";

}
