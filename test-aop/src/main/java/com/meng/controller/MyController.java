package com.meng.controller;

import com.meng.User;
import com.meng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/user/list")
    public String listUser() {
        return userMapper.listUser().toString();
    }

    @RequestMapping("/user/get/{id}")
    public String getUser(@PathVariable("id") Integer id) {
        return userMapper.getName(id);
    }

    @RequestMapping("user/update")
    @Transactional// 这里加上这个注解，事务就没发提交了？why?zai controller里可以。
    public void updateUser() {
        try {
            User user = new User("Harden",123);

            userMapper.updateUser(user);
            int i = 1 / 0;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
