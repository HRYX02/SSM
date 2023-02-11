package com.sxx.mybatis.test;

import com.sxx.mybatis.mapper.EmpMapper;
import com.sxx.mybatis.pojo.Emp;
import com.sxx.mybatis.pojo.EmpExample;
import com.sxx.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据ID查询数据
        /*Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);*/

        //查询所有数据
        /*List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);*/

        //根据条件查询数据
        /*EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
        empExample.or().andGenderEqualTo("男");
        List<Emp> emps = mapper.selectByExample(empExample);
        emps.forEach(System.out::println);*/

        Emp emp =  new Emp(1,"小黑",null,"女");
        //测试普通修改功能
        //mapper.updateByPrimaryKey(emp);
        //测试选择性修改
        mapper.updateByPrimaryKeySelective(emp);
    }
}
