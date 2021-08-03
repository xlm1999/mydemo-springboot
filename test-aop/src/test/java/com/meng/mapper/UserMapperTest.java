package com.meng.mapper;

import com.meng.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void addUser() {
        User user = new User();
        user.setName("Harden");
        user.setAge(12);
        userMapper.addUser(user);
    }

    @Test
    @Transactional// 这里加上这个注解，事务就没发提交了？why
    @Rollback(false)
    public void updateUser() {
            User user = new User("Harden",33);

            userMapper.updateUser(user);
            int i = 1 / 0;



    }

    @Test
    public void deleteUser(){
        userMapper.deleteUser(1);
    }




}