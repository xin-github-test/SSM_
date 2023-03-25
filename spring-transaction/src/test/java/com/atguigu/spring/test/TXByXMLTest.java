package com.atguigu.spring.test;

import com.atguigu.spring.Controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 声明式事务的配置步骤：
 * 1.在spring的配置文件中配置事务管理器
 * 2.开启事务的注解驱动
 *
 * 最后只要在被需要事务管理的方法上，添加@Transactional注解，该方法就会被事务管理
 * @Transactional注解标识的位置：
 * 1.标识在方法上：该方法被事务管理
 * 2.标识在类上：则类中所有的方法都会被事务管理
 *
 * @Transactional注解中的属性（事务的属性）：
 * 1.readOnly:设置为true,则为告诉数据库，该操作不涉及写，此时数据库可以针对查询操作进行优化
 * 2.timeout:事务在执行过程中遇到某些问题而导致卡住，从而长时间占用数据库资源，该属性则用于设置等待时间，
 *            超时回滚，释放资源
 * 3.回滚策略：声明式事务只针对运行时异常回滚，编译时异常不回滚
 *          1.rollbackFor（基本不用）:设置class类型的对象,遇到该异常回滚，默认针对所有运行时异常
 *          2.rollbackForClassName（基本不用）:设置字符串类型的全类名，遇到该异常回滚，默认针对所有运行时异常
 *          3.noRollbackForClassName:设置字符串类型的全类名，遇到该异常不回滚
 *          4.noRollbackForClassName:设置字符串类型的全类名，遇到该异常不回滚
 * 4.事务隔离级别（isolation）：数据库系统必须具有隔离并发运行各个事务的能力，使它们不会相互影响，避免各种并发问题，一个
 *              事务与其他事务隔离的程度称为隔离级别。SQL标准中规定了多种事务隔离级别，不同隔离级别对应
 *              不同的干扰程度，隔离级别越高，数据一致性越好，但并发性越弱
 *          隔离级别：
 *          1.READ UNCOMMITTED（读未提交）:允许Transaction01读取Transaction02未提交的数据，
 *                                       容易造成脏读
 *          2.READ COMMITTED（读已提交）：要求Transaction01只能读取Transaction02已提交的修改，
 *                                      容易造成不可重复读（俩次读取的结果不一样）
 *          3.REPEATABLE READ（可重复读）：确保Transaction01可以多次从一个字段中读取到相同的值，
 *                                       即Transaction01执行期间禁止其它事务对这个字段进行更新，
 *                                       容易造成幻读（俩次读取结果有差异），mysql避免了幻读的情况，
 *                                       这也是mysql的默认隔离级别
 *          4.SERIALIZABLE（串行化）：确保Transaction01可以多次从一个表中读取到相同的行，在
 *                                  Transaction01执行期间，禁止其他事务对这个表进行添加、更新、
 *                                  删除操作。可以避免任何并发问题，但性能十分低下
 *5.传播行为（propagation）:当事务出现嵌套时，设置具体使用那个事务
 *          1.REQUIRED:使用调用者的事务
 *          2.REQUIRED_NEW:开启一个新事务，使用自身事务
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TXByXMLTest {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
        //bookController.checkout(1,new Integer[]{1,2});
    }
}
