package com.tank.spike.controller;

import com.tank.spike.anno.Router;
import com.tank.spike.protocol.req.ActiveMemberReq;
import com.tank.spike.protocol.resp.ActiveMemberResp;
import com.tank.spike.protocol.resp.ResultApi;
import com.tank.spike.protocol.resp.ResultApiWrapper;
import lombok.NonNull;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.tank.spike.constants.UrlPrefix.URL_FOR_ACTIVE_MEMBERS;

/**
 * @author tank198435163.com
 */
@Router("会员路由")
public class MemberCtrl {

  @PostMapping(URL_FOR_ACTIVE_MEMBERS)
  public ResponseEntity<ResultApi<ActiveMemberResp>> fetchActiveMembers(@RequestBody @NonNull final ActiveMemberReq activeMemberReq) {

    val store = activeMemberReq.getStoreModel();

    if (store.isEmptyStoreCode()) {
      throw new IllegalArgumentException("storeCode not allowed error");
    }

    if (store.isEmptyDateStr()) {
      throw new IllegalArgumentException("dateStr not allowed error");
    }

    val activeMemberResp = new ActiveMemberResp();
    activeMemberResp.setMembers(50);
    val result = ResultApiWrapper.payLoad(activeMemberResp);
    return ResponseEntity.ok(result);

  }
}
