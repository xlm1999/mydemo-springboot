package com.meng.service.impl;

import com.meng.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void selectUser() {
        System.out.println("查询用户");
    }

    @Override
    public void addUser() {
        System.out.println("添加用户");
    }
}
