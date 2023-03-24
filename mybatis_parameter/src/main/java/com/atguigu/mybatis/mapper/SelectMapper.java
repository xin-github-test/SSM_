package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.ognl.ObjectElementsAccessor;

import java.beans.IntrospectionException;
import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询用户的总数量
     * @return
     */
    Integer getCount();

    /**
     * 根据id查询用户信息为一个Map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有的用户信息为一个Map集合 将查询出来的多个map放到一个List中
     * @return
     */
    List<Map<String,Object>> getAllUserToMap();

    /**
     * 查询所有的用户信息为一个Map集合 将查询到的多个map再次放入到一个Map中
     * 由于Map的存放形式为键值对类型，因此使用@MapKey注解，将查询到的数据的某个字段设置为键
     * 此处将查询到的数据的id值作为存放的键，其中的值则为查询到的Map集合
     * @return
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMaps();
}
