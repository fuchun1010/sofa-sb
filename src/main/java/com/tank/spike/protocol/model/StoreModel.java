package com.tank.spike.protocol.model;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Queues;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

import java.beans.Transient;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author tank198435163.com
 */
@Getter
@Setter
public class StoreModel {

  @Transient
  public String ordersKey() {
    val dateTime = DateUtil.parseDate(dateStr);
    val date = DateUtil.format(dateTime, DatePattern.NORM_DATE_PATTERN);
    return StrUtil.format("{}:{}:orders", date, storeCode).replace("-", "");
  }

  @Transient
  public Queue<String> hourKey() {
    val dateTime = DateUtil.parseDateTime(dateStr);
    int currentHour = dateTime.getField(DateField.HOUR_OF_DAY);
    val orderKey = this.ordersKey();
    return IntStream.rangeClosed(0, currentHour)
            .boxed()
            .map(hour -> StrUtil.format("{}:{}", orderKey, hour))
            .collect(Collectors.toCollection(Queues::newArrayDeque));
  }


  private String storeCode;

  private String dateStr;


}
