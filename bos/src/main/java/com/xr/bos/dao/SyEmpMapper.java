package com.xr.bos.dao;

import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyRoles;
import com.xr.bos.model.SyUnits;
import org.apache.ibatis.annotations.Select;
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


    //查询所有员工，登录的人看不到自己的信息
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
    @Select("SELECT ID,RoleName from sy_roles")
    List<SyRoles> selectedRolesByRolesName();

    /**
     * 下拉框单位查询
     * @return
     */
    @Select("SELECT ID,Name from sy_units")
    List<SyUnits> selectedUntisByName();

    /**
     * 查询最大的工号
     * @return
     */
    @Select(" SELECT MAX(EmpNo) FROM sy_emp")
    String findMaxByEmpNo();

}
