package com.atguigu.spring.test;

import com.atguigu.spring.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPByAnnotationTest {

    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
//      获取代理对象，只能通过接口，因为目标类不在IOC容器中
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.sub(1,1);
    }
}
