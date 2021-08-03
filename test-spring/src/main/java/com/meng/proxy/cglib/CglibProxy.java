package com.meng.proxy.cglib;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CglibProxy implements MethodInterceptor {

    // 增强器，动态代码生成器
    Enhancer enhancer = new Enhancer();

    /**
     * 创建代理对象
     * @param clazz
     * @return
     */
    public Object getProxy(Class clazz) {
        // 设置父类，也就是被代理的类（目标类）
        enhancer.setSuperclass(clazz);
        // 设置回调，在调用父类方法时，回调this.intercept().
        enhancer.setCallback(this);
        // 通过字节码技术动态创建子类实例，动态扩展了UserServiceImpl类
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("测试intercept方法的四个参数的含义");
        System.out.println("obj: " + o.getClass());
        System.out.println("method: " + method.getName());
        System.out.println("methodProxy: " + methodProxy.getSuperName());
        for (Object value : objects) {
            System.out.println("args: " + value);
        }

        System.out.println("目标方法执行前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("目标方法执行后");
        return result;
    }
}
