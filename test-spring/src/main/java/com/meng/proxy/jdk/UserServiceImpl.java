package com.meng.proxy.jdk;

public class UserServiceImpl implements IUserService{
    
    public void addUser(){
        System.out.println("新增了一个用户！");
    }
    
    public void deleteUser(){
        System.out.println("删除了一个用户！");
    }
}