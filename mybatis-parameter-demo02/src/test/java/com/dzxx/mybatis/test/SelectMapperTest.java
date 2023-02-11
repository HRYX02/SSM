package com.dzxx.mybatis.test;

import com.dzxx.mybatis.mapper.SelectMapper;
import com.dzxx.mybatis.pojo.User;
import com.dzxx.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        //org.apache.ibatis.exceptions.TooManyResultsException: Expected one result (or null) to be returned by selectOne(), but found: 3
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
    }
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> user = mapper.getUserByIdToMap(1);
        //{password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=root}
        System.out.println(user);
    }
    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        /*List<Map<String, Object>> users = mapper.getAllUserToMap();
        System.out.println(users);
        users.forEach(System.out::println);*/
        Map<String, Object> users = mapper.getAllUserToMap();
        //{1={password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=root}, 2={password=123456, gender=男, id=2, age=33, email=123@163.com, username=admin}, 3={password=123456, gender=男, id=3, age=22, email=123@qq.com, username=zhangsan}}{1={password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=root}, 2={password=123456, gender=男, id=2, age=33, email=123@163.com, username=admin}, 3={password=123456, gender=男, id=3, age=22, email=123@qq.com, username=zhangsan}}
        System.out.println(users);
    }
}
