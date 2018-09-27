package com.qf.shopping.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个注解是用来横切关注网站访问请求的
 * 在这里实现免登陆
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.METHOD)
@Documented
public @interface BeforeRequirManager {
	String description() default "";
}
