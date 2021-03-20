package com.tank.spike.erp;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.tank.spike.protocol.req.erp.Cell;
import com.tank.spike.protocol.req.erp.ColumnMetaData;
import com.tank.spike.protocol.req.erp.RawTicketReq;
import com.tank.spike.protocol.req.erp.Row;
import lombok.NonNull;
import lombok.val;

import java.util.List;

/**
 * @author tank198435163.com
 */
public class TicketWrapper {


  public List<Row> toRows(@NonNull final RawTicketReq.ElementsBean element) {
    val columnMetaData = new ColumnMetaData(element.getColumns());
    val records = Lists.<Row>newLinkedList();
    val rawRows = element.getRows();

    for (List<String> row : rawRows) {
      val size = row.size();
      val record = new Row();
      for (int i = 0; i < size; i++) {
        val fieldName = columnMetaData.index(i);
        val cell = new Cell();
        val value = row.get(i);
        if (!StrUtil.isBlank(value)) {
          cell.setValue(value);
        }
        cell.setFieldName(fieldName);
        cell.setIndex(i);
        record.add(cell);
      }
      records.add(record);
    }

    return records;
  }


}
