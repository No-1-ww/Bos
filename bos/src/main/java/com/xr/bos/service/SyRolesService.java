package com.xr.bos.service;

import com.xr.bos.model.SyRoles;

import java.util.List;

public interface SyRolesService {

    //查询所有的角色
    //	SELECT * from sy_roles
    List<SyRoles> findRolesAll();
}
