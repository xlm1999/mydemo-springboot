package com.meng.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAspect {
    // 定义一个切点
    @Pointcut("execution(* com.meng.service.*.*(..))")
    public void myPointCut() {}

    // 前置通知
    @Before("myPointCut()")
    public void beforeAdvice() {
        System.out.println("@Before");
    }
}
