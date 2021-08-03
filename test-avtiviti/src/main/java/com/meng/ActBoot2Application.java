package com.meng;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * @author tanoak@qq.com
 * @date 2019/1/18 17:30    
 * @Description 启动类
 * @version 1.0
 */ 
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ActBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(ActBoot2Application.class, args);
	}
}
