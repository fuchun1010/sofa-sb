package com.tank.spike.controller;

import cn.hutool.core.util.StrUtil;
import com.tank.spike.constants.UrlPrefix;
import com.tank.spike.protocol.resp.ActiveMemberResp;
import com.tank.spike.protocol.resp.ResultApi;
import com.tank.spike.protocol.resp.ResultApiWrapper;
import lombok.NonNull;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.tank.spike.constants.UrlPrefix.URL_FOR_ACTIIVE_MEMBERS;

/**
 * @author tank198435163.com
 */
@CrossOrigin
@RestController
@RequestMapping(UrlPrefix.URL_PREFIX)
public class MemberCtrl {

  @GetMapping(URL_FOR_ACTIIVE_MEMBERS)
  public ResponseEntity<ResultApi<ActiveMemberResp>> fetchActiveMembers(@NonNull @PathVariable final String storeCode,
                                                                        @NonNull @PathVariable final String dateStr) {

    if (StrUtil.isEmptyIfStr(storeCode)) {
      throw new IllegalArgumentException("storeCode not allowed error");
    }

    if (StrUtil.isEmptyIfStr(dateStr)) {
      throw new IllegalArgumentException("dateStr not allowed error");
    }

    val activeMemberResp = new ActiveMemberResp();
    activeMemberResp.setMembers(50);
    val result = ResultApiWrapper.payLoad(activeMemberResp);
    return ResponseEntity.ok(result);

  }
}
