package com.meng.aop;

public class UserManagerServiceImpl implements IUserManagerService{

    private String name;

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String findUser() {
        System.out.println("==>执行业务方法findUser,查找的用户是："+name+"=============");
        return name;
    }

    @Override
    public void addUser() {
        System.out.println("==>执行业务方法addUser: " + name);
    }
}