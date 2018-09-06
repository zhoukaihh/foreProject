package com.qf.shopping.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages={"com.qf.shopping.mapper"})
@ComponentScan(basePackages={"com.qf.shopping"})
public class AppConfig {

}
