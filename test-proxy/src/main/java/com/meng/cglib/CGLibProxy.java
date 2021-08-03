package com.meng.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CGLibProxy  implements MethodInterceptor {

    /**
     * 要被代理的目标对象
     */
    private A target;

    public CGLibProxy(A target){
        this.target=target;
    }

    /**
     * 创建代理对象
     * @return
     */
    public A createProxy(){
        // 使用CGLIB生成代理:
        // 1.声明增强类实例,用于生产代理类
        Enhancer enhancer = new Enhancer();
        // 2.设置被代理类字节码，CGLIB根据字节码生成被代理类的子类
        enhancer.setSuperclass(target.getClass());
        // 3.//设置回调函数，即一个方法拦截
        enhancer.setCallback(this);
        // 4.创建代理:
        return (A) enhancer.create();
    }

    /**
     * 调用被代理类(目标对象)的任意方法都会触发invoke方法
     * @param proxy 代理类
     * @param method 被代理类的方法
     * @param args 被代理类的方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //过滤不需要该业务的方法
        if("execute".equals(method.getName())) {
            //调用前验证权限
            //AuthCheck.authCheck();
            System.out.println("增强前...");
            //调用目标对象的方法
            Object result = methodProxy.invokeSuper(proxy, args);
            //记录日志数据
            //Report.recordLog();
            System.out.println("增强后...");
            return result;
        }else if("delete".equals(method.getName())){
            //.....
        }
        //如果不需要增强直接执行原方法
        return methodProxy.invokeSuper(proxy, args);
    }
}