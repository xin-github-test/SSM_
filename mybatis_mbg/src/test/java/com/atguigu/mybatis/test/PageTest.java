package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {
//    测试分页功能
    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

//        在查询功能之前开启分页功能 其中page里面封装了分页功能的部分数据
        Page<Object> page = PageHelper.startPage(1, 4);

        List<Emp> list = mapper.selectByExample(null);
//        查询功能之后可以获取分页相关的所有数据 navigatePages:导航分页页码数
//        pageInfo封装了更加丰富的数据
        PageInfo<Emp> pageInfo = new PageInfo<>(list,5);
/**
 * PageInfo{pageNum=1, pageSize=4, size=4,
 * startRow=1, endRow=4, total=30,pages=8,
 * list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4,
 * total=30, pages=8, reasonable=false, pageSizeZero=false}
 * [com.atguigu.mybatis.pojo.Emp@5386659f, com.atguigu.mybatis.pojo.Emp@14028087,
 * com.atguigu.mybatis.pojo.Emp@cecf639, com.atguigu.mybatis.pojo.Emp@1caa0244],
 * prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false,
 * hasNextPage=true,
 * navigatePages=5, navigateFirstPage=1, navigateLastPage=5,navigatepageNums=[1, 2, 3, 4, 5]}
 */
//      没有开启分页查询的时候，查询的是所有的数据，开启之后，查询的是pageNum条数据据
        list.forEach(System.out::println);
        System.out.println(pageInfo);

    }
}
