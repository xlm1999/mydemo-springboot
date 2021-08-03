package com.meng.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserManagerService userManager = context.getBean("userManager", IUserManagerService.class);
        userManager.findUser();
        System.out.println();
        userManager.addUser();
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserManagerService userManager = context.getBean("userManager", IUserManagerService.class);
        userManager.findUser();
    }
}
