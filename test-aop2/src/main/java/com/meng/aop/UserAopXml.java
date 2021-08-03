package com.meng.aop;

import org.springframework.aop.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 基于纯xml配置的方式实现aop
 */
public class UserAopXml {
    public void doBefore() {
        System.out.println("方法执行前通知-before");
    }

    public void doAfter() {
        System.out.println("方法执行后通知-after");
    }

    public void doAfterReturning() {
        System.out.println("方法执行后通知-AfterReturning");
    }

    public void doAfterThrowing() {
        System.out.println("方法执行异常通知-AfterThrowing");
    }

    public void doAroud() {
        System.out.println("方法环绕通知-Aroud");
    }
}
