package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * 在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before:前置通知的注解
 */
@Component
@Aspect   //将当前组件标识为切面
public class LoggerAspect{

//    设置一个公共的切入点
    @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    //    @Before("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int,int))")
//    若是需要获取方法信息，可以利用 JoinPoint joinPoint对象来获取，该对象封装了所定位的方法
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
//        获取连接点所对应方法的方法名
        Signature signature = joinPoint.getSignature();
//        获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法:"+signature.getName()+",参数:"+ Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(){

    }
}
