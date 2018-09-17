package com.qf.shopping.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootConfiguration
@MapperScan(basePackages={"com.qf.shopping.mapper"})
@ComponentScan(basePackages={"com.qf.shopping"})
public class AppConfig {

}
