package com.xr.bos.service;

import com.xr.bos.model.SyEmp;

import java.util.List;
import java.util.Map;

public interface SyEmpService {
    List<SyEmp> select();

    SyEmp logIn(String empNo);

    List<Map<String,Object>> queryRoles(SyEmp syEmp);

    //查询是否有该电话号码存在
    int queryExitPhone(String phone);

    SyEmp logInDx(String phone);

    List<SyEmp> querySyEmp(Integer id);
}
