package com.meng.cglib;

public class MyTest {
    public static void main(String args[]){
        A a=new A();
        //创建JDK代理
        CGLibProxy cgLibProxy=new CGLibProxy(a);
        //创建代理对象
        ExInterface proxy=cgLibProxy.createProxy();
        //执行代理对象方法
        proxy.execute();
    }
}
