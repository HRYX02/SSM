package com.dzxx.mybatis.mapper;

import com.dzxx.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    User getUserById(@Param("id") Integer id);
    List<User> getAllUser();
    Integer getCount();
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);
    //List<Map<String, Object>> getAllUserToMap();
    /**
     * 查询所有的用户信息为map集合
     * 若查询的数据有多条时，并且要将每条数据转换为map集合
     * 此时有两种解决方案：
     * 1、将mapper接口方法的返回值设置为泛型是map的list集合
     * List<Map<String, Object>> getAllUserToMap();
     * 结果：{password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin},{password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin}
     * 2、可以将每条数据转换的map集合放在一个大的map中，但是必须要通过@MapKey注解
     * 将查询的某个字段的值作为大的map的键
     * @MapKey("id")
     * Map<String, Object> getAllUserToMap();
     * 结果：
     * {
     *  1={password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin},
     *  2={password=123, gender=男, id=2, age=23, email=12345@qq.com, username=zhangsan},
     *  3={password=123456, gender=女, id=3, age=33, email=123@qq.com, username=root},
     *  4={password=123, id=4, username=lisi}
     *  }
     */
    @MapKey("id")
    Map<String, Object> getAllUserToMap();
}
