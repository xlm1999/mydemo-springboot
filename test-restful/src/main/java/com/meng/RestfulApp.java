package com.meng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.meng.mapper")
public class RestfulApp {
    public static void main(String[] args) {
        SpringApplication.run(RestfulApp.class, args);
    }
}
