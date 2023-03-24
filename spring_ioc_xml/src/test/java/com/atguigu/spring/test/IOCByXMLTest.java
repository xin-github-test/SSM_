package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Person;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {

    @Test
    public void testIOC(){
//        获取容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
//        获取bean的方法
        /**
         * 1.通过bean的id获取
         * 2.通过bean的类型获取：要求IOC容器中有且只有一个类型匹配的bean,有多个或没有都报错）
         * 3.根据bean的id和类型获取
         * 若是组件实现了接口，根据接口类型也可以获取bean(前提是bean唯一)，若是一个接口有
         * 多个实现类且都配置了bean,则获取不到，因为bean不唯一
         * 使用bean所继承的类的类型也可以
         */
//        Student studentOne = (Student) ioc.getBean("studentOne");
//        Student bean = ioc.getBean(Student.class);
//        Student studentOne = ioc.getBean("studentOne", Student.class);
        Person bean = ioc.getBean(Person.class);
        System.out.println(bean);

    }

    @Test
    public void testDI(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student studentOne = ioc.getBean("studentSix", Student.class);
        System.out.println(studentOne);

//        Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
//        System.out.println(clazz);
    }
}
