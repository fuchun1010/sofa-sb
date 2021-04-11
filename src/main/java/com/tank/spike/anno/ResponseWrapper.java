package com.tank.spike.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author tank198435163.com
 */
@Inherited
@Documented
@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface ResponseWrapper {
}
