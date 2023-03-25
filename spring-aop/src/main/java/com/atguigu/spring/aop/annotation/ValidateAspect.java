package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)  //设置切面类执行的优先级，数字越小优先级越高，默认是最低优先级
public class ValidateAspect {
//    @Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    //可以访问别的类中的重用pointcut
    @Before("com.atguigu.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect->前置通知");
    }

}
