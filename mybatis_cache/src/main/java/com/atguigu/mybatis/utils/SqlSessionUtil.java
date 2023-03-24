package com.atguigu.mybatis.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static void readFromFile(InputStream in){
        StringBuilder sb=new StringBuilder();
        try{
            byte buffer[]=new byte[256];
            while(in.read(buffer,0,256)!=-1){//-1表示读取结束
                sb.append(new String(buffer));
            }
            System.out.println("全文："+sb.toString());
            System.out.println("完成!");
        }catch(Exception ex){
            System.out.println(ex.toString());
        }finally{//不管是否出现异常，都要确保关闭以释放资源
            try{
                in.close();
            }catch(IOException ioEx){
                System.out.println(ioEx.toString());
            }
        }
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try {
//            获取核心配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//            readFromFile(is);
//            获取SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//            获取SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//            获取SqlSession  自动提交事务
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
