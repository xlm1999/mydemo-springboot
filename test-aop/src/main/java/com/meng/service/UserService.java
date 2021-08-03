package com.meng.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserService{
    public void addUser() {
        System.out.println("添加了一个用户");
    }

    public void updateUser() {
        System.out.println("修改了一个用户");
    }
}
