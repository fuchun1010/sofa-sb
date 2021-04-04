package com.tank.spike.protocol.req.erp;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NonNull;

import java.beans.Transient;
import java.util.List;

/**
 * @author tank198435163.com
 */
public class Row {

  @Transient
  public void add(@NonNull final Cell cell) {
    this.cells.add(cell);
  }

  @Getter
  private final List<Cell> cells = Lists.newArrayList();
}
