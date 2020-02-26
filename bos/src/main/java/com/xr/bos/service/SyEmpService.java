package com.xr.bos.service;

import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyRoles;
import com.xr.bos.model.SyUnits;
import org.apache.ibatis.annotations.Select;

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

    //验证入库交接单
    SyEmp check(String empName);

    //查询所有员工
    List<Map<String,Object>> findEmpAll(Integer id);

    /**
     * 多条件查询
     * @param syEmp
     * @return
     */
    List<Map<String,Object>> findEmpByNameOrDisabled(SyEmp syEmp);

    /**
     * 下拉框角色名 查询
     * @return
     */
    List<SyRoles> selectedRolesByRolesName();

    /**
     * 下拉框单位查询
     * @return
     */
    List<SyUnits> selectedUntisByName();

    /**
     * 查询最大的工号
     * @return
     */
    String findMaxByEmpNo();
}
