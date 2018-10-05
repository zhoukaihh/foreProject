package com.qf.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class AppStart {

	public static void main(String[] args) {
		SpringApplication.run(AppStart.class, args);
		System.out.println("启动了....");
	}
}
