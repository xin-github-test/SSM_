package com.atguigu.mybatis.test;

import atguigu.mybatis.mapper.UserMapper;
import atguigu.mybatis.pojo.User;
import atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {

//    @Test
//    public void testInsert() throws IOException {
//
////        获取核心配置文件的输入流
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
////        获取SqlSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////        获取SqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//
////        获取sql的会话对象SqlSession,是用于操作数据库的对象 此时的事务是需要自己管理的,但可以通过参数设置自动提交
//        SqlSession sqlSession = sqlSessionFactory.openSession();
////        设置自动提交事务,最后不需要手动commit
////        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//
////        获取UserMapper的代理实现类对象
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        若是没有接口，则可以直接通过映射文件中的唯一标识定位相应的sql语句并执行
////        int result = sqlSession.insert("atguigu.mybatis.mapper.UserMapper.insertUser")
//        int result = mapper.inserUser();
//        System.out.println("结果:"+result);
//
////        sql语句执行完成之后，注意提交事务
//        sqlSession.commit();
////        关闭sqlsession对象
//        sqlSession.close();
//
//
//    }
//
//    @Test
//    public void testUpdate(){
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.updateUser();
//        sqlSession.close();
//
//    }
//    @Test
//    public void testDelete(){
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.deleteUser();
//        sqlSession.close();
//
//    }
//
//    @Test
//    public void testGetUserById(){
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.getUserById();
//        System.out.println(user);
//        sqlSession.close();
//    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);

        sqlSession.close();
    }
}
