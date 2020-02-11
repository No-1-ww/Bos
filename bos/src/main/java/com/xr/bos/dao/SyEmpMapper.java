package com.xr.bos.dao;

import com.xr.bos.model.SyEmp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SyEmpMapper {

    List<SyEmp> select();

    SyEmp logIn(String empNo);

    List<Map<String,Object>> queryRoles(SyEmp syEmp);


    //查询是否有该电话号码存在
    int queryExitPhone(String phone);

     SyEmp logInDx(String phone);

     //查询除去当前用户的所有用户
    List<SyEmp> querySyEmp(Integer id);


    //验证入库交接单
    SyEmp check(String empName);

}
