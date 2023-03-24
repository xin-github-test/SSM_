import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {



    @Test
    public void testGetEmpById(){
        /**
         * 一级缓存：默认开启的，是sqlSession级别的，同一个sqlSeesion查询的数据会被缓存
         * 下次的查询会从缓存中直接获取，不会从数据库中重新访问
         *
         * 是得一级缓存失效的四种情况：
         * 1.不同的sqlSession对应不同的缓存
         * 2.同一个sqlSession但是查询条件不同
         * 3.同一个sqlSession俩次查询期间执行了一次增删改操作
         * 4.同一个sqlSession俩次查询期间手动清空了缓存
         */
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
//        第一次从数据库中查询的
        Emp emp1 = mapper.getEmpById(2);
        System.out.println(emp1);

//        中间加上一个添加操作
//        mapper.insertEmp(new Emp(null,"小红",25,"男"));

//        手动清空缓存
        sqlSession.clearCache();

//        第二次则是从缓存中查询的，此时没有使用sql语句查询
        Emp emp2 = mapper.getEmpById(2);
        System.out.println(emp2);
    }

    /**
     * 二级缓存：二级缓存是SqlSessionFactory级别的，通过一个SqlSessionFactory创建的SqlSession
     * 查询的结果会被缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取
     * 二级缓存开启的条件
     * 1.在核心配置文件中，设置全局配置属性cacheEnable="true",默认为true,不需要设置
     * 2.在映射文件中设置标签<cache></cache>
     * 3.二级缓存必须在SqlSession关闭或提交之后有效
     * 4.查询的数据所转换的实体类必须实现序列化接口
     *
     * 使得二级缓存失效的情况：
     * 俩次查询之间执行了任意的增删改查，会使一级和二级缓存同时失效
     */

    /**
     * 使用第三方缓存：其共功能和原生的时一样的
     * @throws IOException
     */

    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);

//        注意：需要将sqlSession关闭或提交之后，才会将数据保存到二级缓存，否则还是在一级缓存
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2= mapper2.getEmpById(1);
        System.out.println(emp2);

    }
}
