package com.meng.test.aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 五月的仓颉http://www.cnblogs.com/xrq730/p/7003082.html
 */
public class DaoProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();

        if ("insert".equals(methodName) || "update".equals(methodName)) {
            System.out.println(methodName + "()方法开始时间：" + System.currentTimeMillis());
            proxy.invokeSuper(object, objects);
            System.out.println(methodName + "()方法结束时间：" + System.currentTimeMillis());

            return object;
        }

        proxy.invokeSuper(object, objects);
        return object;
    }

}