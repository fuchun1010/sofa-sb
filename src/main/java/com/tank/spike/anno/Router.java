package com.tank.spike.anno;

import com.tank.spike.constants.UrlPrefix;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @author tank198435163.com
 */
@Documented
@CrossOrigin
@RestController
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(UrlPrefix.URL_PREFIX)
public @interface Router {
  String value();
}
