package com.meng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MyTest.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        System.out.println(run.getBean(GpCoreService.class));
//        GpCoreService bean = run.getBean(GpCoreService.class);
//        bean.crudService();
    }
}
