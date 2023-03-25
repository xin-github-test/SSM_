package com.atguigu.spring.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class ValidateAspect {
//    @Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    //可以访问别的类中的重用pointcut

    public void beforeMethod(){
        System.out.println("ValidateAspect->前置通知");
    }

}
