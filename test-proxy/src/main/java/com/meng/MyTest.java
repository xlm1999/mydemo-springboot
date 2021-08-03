package com.meng;

public class MyTest {
    public static void main(String args[]){
        A a=new A();
        //创建JDK代理
        JDKProxy jdkProxy=new JDKProxy(a);
        //创建代理对象
        ExInterface proxy=jdkProxy.createProxy();
        //执行代理对象方法
        proxy.execute();
    }
}
