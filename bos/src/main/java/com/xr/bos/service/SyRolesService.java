package com.xr.bos.service;

import com.xr.bos.model.SyRoles;

import java.util.List;

public interface SyRolesService {

    //查询所有的角色
    //	SELECT * from sy_roles
    List<SyRoles> findRolesAll();

    //根据条件查询
    List<SyRoles> findRolesWhereRolesNameAndDisabled(SyRoles syRoles);

    /**
     * 添加角色
     * @param syRoles
     * @return
     */
    int addSysRoles(SyRoles syRoles);

    /**
     * 编辑查询根据id获取值
     * @param syRoles
     * @return
     */
    List<SyRoles> findRolesWhereUpdateById(SyRoles syRoles);


    /**
     * 修改角色信息
     * @param syRoles
     * @return
     */
    int updateSysRolesByid(SyRoles syRoles);
}
