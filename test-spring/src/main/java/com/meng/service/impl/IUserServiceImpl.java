package com.meng.service.impl;

import com.meng.service.IUserService;

public class IUserServiceImpl implements IUserService {

    private String message;

    public IUserServiceImpl(String message) {
        this.message = message;
    }

    public IUserServiceImpl() {
    }

    @Override
    public void show() {
        System.out.println("hello,"+message);
    }

}
