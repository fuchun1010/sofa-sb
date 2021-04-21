package com.tank.spike.cache;

import com.alicp.jetcache.anno.Cached;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @param <T>
 * @author tank198435163.com
 */
@Component
public interface CacheService<T> {

  @Cached(name = "global-",
          timeUnit = TimeUnit.MINUTES,
          expire = 10)
  T obtainCache(@NonNull final Integer cacheKey);

}
