package com.tank.spike.protocol.model;

import lombok.val;
import org.junit.Before;
import org.junit.Test;

public class StoreModelTest {

  @Test
  public void testOrdersKey() {
    val dateStr = this.storeModel.ordersKey();
    System.out.println(dateStr);
  }

  @Test
  public void testHourKey() {
    val hourKeys = this.storeModel.hourKey();
    hourKeys.forEach(System.out::println);
  }

  @Before
  public void init() {
    this.storeModel = new StoreModel();
    this.storeModel.setDateStr("2020-11-19 11:37:59");
    this.storeModel.setStoreCode("store_1004");
  }

  private StoreModel storeModel;
}