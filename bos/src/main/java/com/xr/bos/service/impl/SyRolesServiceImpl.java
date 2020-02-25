package com.xr.bos.service.impl;

import com.xr.bos.dao.SyRolesMapper;
import com.xr.bos.model.SyRoles;
import com.xr.bos.service.SyRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyRolesServiceImpl implements SyRolesService {

    @Autowired
    private SyRolesMapper syRolesMapper;

    /*查询所有角色*/
    @Override
    public List<SyRoles> findRolesAll() {

        return syRolesMapper.findRolesAll();
    }

    @Override
    public List<SyRoles> findRolesWhereRolesNameAndDisabled(SyRoles syRoles) {
        return syRolesMapper.findRolesWhereRolesNameAndDisabled(syRoles);
    }

    @Override
    public int addSysRoles(SyRoles syRoles) {
        return syRolesMapper.addSysRoles(syRoles);
    }

    @Override
    public List<SyRoles> findRolesWhereUpdateById(SyRoles syRoles) {
        return syRolesMapper.findRolesWhereUpdateById(syRoles);
    }

    @Override
    public int updateSysRolesByid(SyRoles syRoles) {
        System.out.println("进入serviceimpl......");
        return syRolesMapper.updateSysRolesByid(syRoles);
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @Override
    public int delSysRolesByid(Integer id) {
        return syRolesMapper.delSysRolesByid(id);
    }
}
