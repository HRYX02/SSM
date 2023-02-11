package com.dzxx.mybatis.test;

import com.dzxx.mybatis.mapper.SpecialSQLMapper;
import com.dzxx.mybatis.pojo.User;
import com.dzxx.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSQLMapperTset {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> user = mapper.getUserByLike("ad");
        user.forEach(System.out::println);
    }
    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        int i = mapper.deleteMoreUser("6");
        System.out.println(i);
    }
    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> user = mapper.getUserList("t_user");
        user.forEach(System.out::println);
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null,"lisi","123456",12,"男","1234@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
