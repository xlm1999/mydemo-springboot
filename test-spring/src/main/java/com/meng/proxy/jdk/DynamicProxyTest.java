package com.meng.proxy.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    @Test
    public void test1() {
        IUserService target = new UserServiceImpl();
        DynamicProxy handler = new DynamicProxy(target);
        IUserService proxy = (IUserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),// 目标类的类加载器
                target.getClass().getInterfaces(),// 目标类的接口
                handler);// 横切类

        proxy.addUser();
        //proxy.deleteUser();


    }
}
