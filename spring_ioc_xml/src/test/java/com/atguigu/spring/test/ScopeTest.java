package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {


    @Test
    public void testScope(){

        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");

        Student student1 = ioc.getBean(Student.class);
        Student student2 = ioc.getBean(Student.class);
        //测试是否为单例(spring默认为单例)
/**        bean标签中有一个属性scope用于控制是单例还是多例的
 *          singleton:单例（默认）
 *          prototype:多例
*/

//单例的结果为true,多例为False
        System.out.println(student1.equals(student2));
    }
}
