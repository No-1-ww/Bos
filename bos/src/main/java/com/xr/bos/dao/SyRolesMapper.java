package com.xr.bos.dao;

import com.xr.bos.model.SyRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SyRolesMapper {

    //查询所有的角色
    //	SELECT * from sy_roles
    List<SyRoles>  findRolesAll();

    //根据条件查询，多条件
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

    /**
     * 删除角色
     * @param id
     * @return
     */
    int delSysRolesByid(Integer id);

}
