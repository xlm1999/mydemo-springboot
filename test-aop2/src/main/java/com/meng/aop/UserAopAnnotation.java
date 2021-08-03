package com.meng.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



/**
 * 基于纯注解的方式来实现aop
 */
@Aspect
@Component // 如果基于纯注解的方式，这个注解不能少。
public class UserAopAnnotation {
    @Pointcut("execution(* com.meng.service.impl.*.*(..))")
    public void myPointcut(){}

    @Before("myPointcut()")
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
