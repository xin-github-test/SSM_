package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {
/**
 * @Component：将类标识为普通组件
 * @Controller：将类标识为控制层组件
 * @Service：将类标识为业务层组件
 * @Repository：将类标识为持久层组件
 *
 * 其中四个组件的功能是一样的，只是为了区分不同的类。
 * 使用注解之后，其id默认为类名且首字母小写；使用注解的时候可以自定义id 例如 @Controller("controller")
 *
 * @Autowired: 实现自动装配功能的注解
 * 1.@Autowired 注解能够标识的位置
 * a> 标识在成员变量上，此时不需要设置成员变量的set方法
 * b> 标识在set方法上 和标识在成员变量上的作用一样
 * c> 标识在为当前成员变量赋值的有参构造上 和标识在成员变量上的作用一样
 * 2.@Autowired 注解的原理
 * a> 默认通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
 * b> 若有多个类型匹配的bean,此时会自动转换为byName的方式实现自动装配的效果
 *    将即将要赋值的属性的属性名作为bean的id匹配某个bean为属性赋值
 * c> 若byType和byName的方式都无法实现自动装配，即IOC容器中有多个类型匹配的bean,且这些bean的id和要赋值的属性
 *      的属性名都不一致，此时报错
 * d> 此时可以在要赋值的属性上添加一个注解 @Qualifier
 *      通过该注解的value属性值，指定某个bean的id,将这个bean为属性赋值
 *
**/
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
