package com.meng.aop.annotation;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 使用注解方式
 */
@Component
@Aspect
public class MyAspect {
    public static final String POINTCUT = "execution(* com.meng.aop.UserManagerServiceImpl..*(..))";

    @Before(POINTCUT)
    public void doBefore() {
        System.out.println("==>执行前置通知==========");
    }


}
