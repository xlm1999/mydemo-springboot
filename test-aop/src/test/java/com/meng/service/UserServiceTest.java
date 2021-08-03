package com.meng.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    BrokerService brokerService;

    @Test
    public void addUser() {
        userService.addUser();
    }

    @Test
    public void updateUser() {
        userService.updateUser();
    }

    @Test
    public void test5() {
        brokerService.method1();
    }



}