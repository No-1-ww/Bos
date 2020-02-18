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
}
