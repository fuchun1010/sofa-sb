package com.tank.spike.controller;

import com.tank.spike.anno.Router;
import com.tank.spike.protocol.req.erp.ColumnMetaData;
import com.tank.spike.protocol.req.erp.RawTicketReq;
import com.tank.spike.protocol.resp.ResultApi;
import com.tank.spike.protocol.resp.ResultApiWrapper;
import io.vavr.collection.Stream;
import lombok.NonNull;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.tank.spike.constants.UrlPrefix.URL_FOR_ERP_TICKETS;

/**
 * @author tank198435163.com
 */
@Router("erp小票上传")
public class ErpCrtl {


  @PostMapping(URL_FOR_ERP_TICKETS)
  public ResponseEntity<ResultApi<String>> uploadRawTickets(@NonNull @RequestBody final RawTicketReq rawTicketReq) {

    val column = Stream.ofAll(rawTicketReq.getElements())
            .findLast(elementsBean -> elementsBean.getRowCount() > 0)
            .map(RawTicketReq.ElementsBean::getColumns)
            .getOrElseThrow(IllegalAccessError::new);

    val columnMetaData = new ColumnMetaData(column);


    return ResponseEntity.ok(ResultApiWrapper.payLoad("success"));
  }

}
