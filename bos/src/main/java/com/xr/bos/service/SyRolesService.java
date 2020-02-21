package com.xr.bos.service;

import com.xr.bos.model.SyRoles;

import java.util.List;

public interface SyRolesService {

    //查询所有的角色
    //	SELECT * from sy_roles
    List<SyRoles> findRolesAll();

    //根据条件查询
    List<SyRoles> findRolesWhereRolesNameAndDisabled(SyRoles syRoles);
}
