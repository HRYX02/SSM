package com.sxx.mybatis.mapper;

import com.sxx.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    Emp getEmpByEmpId(@Param("empId") Integer empId);
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);
    /**
     * 通过分布查询查询员工以及所对应的部门信息的第一步
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);
    /**
     * 通过分布查询查询部门以及部门中的员工信息的第二步
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);
}
