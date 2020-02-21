package com.xr.bos.dao;

import com.xr.bos.model.SyRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SyRolesMapper {

    //查询所有的角色
    //	SELECT * from sy_roles
    List<SyRoles>  findRolesAll();

    //根据条件查询
    List<SyRoles> findRolesWhereRolesNameAndDisabled(SyRoles syRoles);

}
