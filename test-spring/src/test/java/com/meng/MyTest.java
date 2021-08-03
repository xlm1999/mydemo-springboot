package com.meng;

import com.meng.entity.Student;
import com.meng.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test1() {
        Student student = context.getBean("student", Student.class);
        System.out.println("student:" + student);

    }

    @Test
    public void test2() {
        IUserService userService = context.getBean("userService", IUserService.class);
        userService.show();
    }
}
