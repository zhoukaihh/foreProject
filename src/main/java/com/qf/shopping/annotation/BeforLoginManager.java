package com.qf.shopping.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 前台用户进行登录的切点注解
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.METHOD)
@Documented
public @interface BeforLoginManager {
	String description() default "";
}
