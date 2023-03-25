package com.atguigu.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * 在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before:前置通知的注解
 * @After:后置通知，在目标对象方法的finally字句中执行的
 * @AfterReturning:返回通知，在目标对象方法返回值之后执行
 * @AfterThrowing:异常通知，在目标对象方法的catch中执行
 */
@Component

public class LoggerAspect{



    //    @Before("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int,int))")
//    若是需要获取方法信息，可以利用 JoinPoint joinPoint对象来获取，该对象封装了所定位的方法

    public void beforeAdviceMethod(JoinPoint joinPoint){
//        获取连接点所对应方法的方法名
        Signature signature = joinPoint.getSignature();
//        获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法:"+signature.getName()+",参数:"+ Arrays.toString(args));
    }


    public void afterAdviceMethod(JoinPoint joinPoint){
        //        获取连接点所对应方法的方法名
        Signature signature = joinPoint.getSignature();
//        获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法："+signature.getName()+"执行完毕");
    }
//其中 returning 用于接收方法的返回值

//    其中 result参数 用于接收方法的返回值
    /**
     *在返回通知中若要获取目标对象方法的返回值
     * 只需要通过@AfterReturning注解的returning属性
     * 就可以将通知方法的某个参数指定为接受目标对象方法的返回值
     *
     */
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:"+signature.getName()+",结果："+result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法："+signature.getName()+",异常:"+ex);
    }

    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知--》前置通知");
            //        标识目标方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知--》返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知--》异常通知");
        }finally {
            System.out.println("环绕通知--》后置通知");
        }
        return result;
    }
}
