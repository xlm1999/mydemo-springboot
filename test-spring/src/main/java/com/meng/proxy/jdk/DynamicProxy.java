package com.meng.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    //被代理对象（就是要给这个目标类创建代理对象）
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 覆盖java.lang.reflect.InvocationHandler的方法invoke()进行织入(增强)的操作。
     * 这个方法是给代理对象调用的，留心的是内部的method调用的对象是目标对象，可别写错。
     * 参数说明：
     * proxy是生成的代理对象，method是代理的方法，args是方法接收的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("目标方法执行前");
        //通过反射机制来调用目标类方法
        Object result = method.invoke(target, args);
        System.out.println("目标方法执行后");
        return result;
    }
}
