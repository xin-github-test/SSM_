package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import com.sun.tools.javac.code.Attribute;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动装配
 * 根据指定的策略，在IOC容器中匹配某个bean,自动为bean中的类类型的属性或是接口类型的属性赋值
 * 通过bean 标签中的autowire属性设置自动装配的策略
 * 自动装配的策略：
 * no,default : 不装配，即bean中的属性不会自动匹配某个bean为属性赋值，此时属性使用默认值
 * byType: 根据要赋值的属性的类型，在IOC容器中匹配某个bean，为属性赋值
 * byName: 将要赋值的属性的属性名作为bean的id在IOC容器中匹配某个bean ,为属性赋值
 *
 * 总结：当类型匹配的bean有多个时，此时可以使用byName实现自动装配
 *
 */
public class AutowireByXMLTest {

    @Test
    public void testAutowire(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
