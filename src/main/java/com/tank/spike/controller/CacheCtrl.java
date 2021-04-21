package com.tank.spike.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.anno.CreateCache;
import com.tank.spike.anno.ResponseWrapper;
import com.tank.spike.anno.Router;
import com.tank.spike.protocol.req.simple.ApplicantReq;
import com.tank.spike.protocol.req.simple.ApplicantRes;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import lombok.var;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author tank198435163.com
 */
@Slf4j
@ResponseWrapper
@Router("缓存controller")
public class CacheCtrl {

  @PostMapping("/apply/job")
  @Cached(name = "global-", expire = 10, timeUnit = TimeUnit.MINUTES)
  public ApplicantRes tryToApplyJob(@NonNull final ApplicantReq applicantReq) {

    val basicHash = Objects.hashCode(applicantReq);
    val hash = basicHash ^ (basicHash >>> 16);
    var result = applicantResCache.get(hash);
    if (Objects.isNull(result)) {
      val applicantRes = new ApplicantRes().setCheckResult("success");
      applicantResCache.put(hash, applicantRes);
      log.info("create cache and return");
    }
    result = Objects.isNull(result) ? applicantResCache.get(hash) : result;
    return ((ApplicantRes) result);
  }

  @CreateCache(expire = 10, timeUnit = TimeUnit.MINUTES, localLimit = 100, name = "global-")
  private Cache<Integer, Object> applicantResCache;


}
