package com.tank.spike.controller;

import com.tank.spike.anno.Router;
import com.tank.spike.erp.TicketWrapper;
import com.tank.spike.protocol.req.erp.RawTicketReq;
import com.tank.spike.protocol.req.erp.Row;
import com.tank.spike.protocol.resp.ResultApi;
import com.tank.spike.protocol.resp.ResultApiWrapper;
import lombok.NonNull;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.tank.spike.constants.UrlPrefix.URL_FOR_ERP_TICKETS;

/**
 * @author tank198435163.com
 */
@Router("erp小票上传")
public class ErpCrtl {


  @PostMapping(URL_FOR_ERP_TICKETS)
  public ResponseEntity<ResultApi<List<Row>>> uploadRawTickets(@NonNull @RequestBody final RawTicketReq rawTicketReq) {

    if (rawTicketReq.isEmptyElements()) {
      throw new IllegalArgumentException("elements not allowed empty");
    }

    val ticketWrapper = new TicketWrapper();

    val rows = ticketWrapper.toRows(rawTicketReq.getElements().get(0));

    return ResponseEntity.ok(ResultApiWrapper.payLoad(rows));
  }

}
