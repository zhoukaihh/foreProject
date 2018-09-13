package com.qf.shopping.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这里定义了一个注解，这个注解的名字就是LoggingManager
 * 在这里要使用元注解来定义:
 * @Target这个注解使用在什么地方
 * @Retention保存在什么范围
 * @Documented拥有这个注解的元素可以被javadoc此类的工具文档化
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.METHOD)
@Documented
public @interface LoggingManager {
	//在这个自定义注解里面设置一个变量，后面用来作为提示信息的容器
	String description() default "";
	
}
