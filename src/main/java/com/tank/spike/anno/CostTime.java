package com.tank.spike.anno;

import java.lang.annotation.*;

/**
 * @author tank198435163.com
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CostTime {

  String tips() default "-";
}
