package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {

    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        根据ID查询数据
//        Emp emp = mapper.selectByPrimaryKey(1);

//        按条件查询，没有条件就是查询全部
//        List<Emp> emps = mapper.selectByExample(null);


/*        EmpExample example = new EmpExample();
//        创建条件 (empName = "张三" and age >= 20) or (gender = "男")
        example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
        example.or().andGenderEqualTo("男");
        List<Emp> emps = mapper.selectByExample(example );


        emps.forEach(System.out::println);*/

        Emp emp = new Emp(1,"小黑",null,"女");
        //      测试普通修改功能 如果修改的内容中有null,表中对应的字段会被改成null
//        mapper.updateByPrimaryKey(emp);
//        选择性修改  修改的内容中有null,表中对应的字段保持原样，不会修改
        mapper.updateByPrimaryKeySelective(emp);
    }
}
