package com.dzxx.mybatis.mapper;

import com.dzxx.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {
    List<User> getUserByLike(@Param("mohu") String mohu);
    int deleteMoreUser(@Param("ids") String ids);
    List<User> getUserList(@Param("tableName") String tableName);
    int insertUser(User user);
}
