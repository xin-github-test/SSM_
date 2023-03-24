package com.atguigu.spring.test;

import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    @Test
    public void test(){
        /**
         * ConfigurableApplicationContext 是 ApplicationContext的子接口,其中扩展了刷新和关闭容器的方法
         */
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        /**
         * bean的生命周期:
         * 1.实例化  (调用无参)
         * 2.依赖注入 (设置属性)
         * 3.bean对象初始化之前的操作(由bean 的后置处理器负责)
         * 4.初始化  通过bean 的init-method 属性来指定初始化的方法
         * 5.bean对象初始化之后的操作(由bean 的后置处理器负责)
         * 6.销毁(IOC容器关闭时,先销毁对象再关闭)  通过 destroy-method 来指定销毁的方法
         */
        /**
         * 当bean的scope设置为单例的时候,bean所对应的对象在容器创建完成之后就被创建了,因此之后通过
         * getBean获取对象都是同一个对象
         *
         * 当设置为多例的时候,在容器创建完成之后,bean对应的对象并没有被创建,只有在
         * 通过getBean获取的时候才创建,因此每一次获取都是新的对象,另外,此时对象的销毁也
         * 不由IOC容器控制了
         */
        User user = ioc.getBean(User.class);
        System.out.println(user);
//        容器关闭,调用销毁方法
        ioc.close();

    }
}
