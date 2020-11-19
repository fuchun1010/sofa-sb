package com.tank.spike.protocol.model;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

import java.beans.Transient;
import java.util.Set;
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
    val dateTime = DateUtil.parseDate(this.dateStr);
    val date = DateUtil.format(dateTime, DatePattern.NORM_DATE_PATTERN);
    return StrUtil.format("{}:{}:orders", date, storeCode).replace("-", "");
  }

  @Transient
  public Set<String> hourKey() {
    val dateTime = DateUtil.parseDateTime(this.dateStr);
    int currentHour = dateTime.getField(DateField.HOUR_OF_DAY);
    val orderKey = this.ordersKey();
    return IntStream.rangeClosed(0, currentHour)
            .boxed()
            .map(hour -> StrUtil.format("{}:{}", orderKey, hour))
            .collect(Collectors.toSet());
  }

  @Transient
  public String activeMemberMomentKey() {
    val dateTime = DateUtil.parseDateTime(this.dateStr);
    val date = DateUtil.format(dateTime, DatePattern.NORM_DATE_PATTERN).replace("-", "");
    int currentHour = dateTime.getField(DateField.HOUR_OF_DAY);
    return StrUtil.format("{}:{}:a:{}", date, this.storeCode, currentHour);
  }


  @Transient
  public boolean isEmptyStoreCode() {
    return StrUtil.isEmptyIfStr(storeCode);
  }

  @Transient
  public boolean isEmptyDateStr() {
    return StrUtil.isEmptyIfStr(this.dateStr);
  }


  private String storeCode;

  private String dateStr;


}
