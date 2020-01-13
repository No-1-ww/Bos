package com.xr.bos.service.impl;

import com.xr.bos.dao.SyEmpMapper;
import com.xr.bos.model.SyEmp;
import com.xr.bos.service.SyEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SyEmpServiceImpl implements SyEmpService {

    @Autowired
    private SyEmpMapper syEmpMapper;

    @Override
    public List<SyEmp> select() {
        return syEmpMapper.select();

    }

    @Override
    public SyEmp logIn(String empNo) {
        return syEmpMapper.logIn(empNo);
    }

    @Override
    public List<Map<String, Object>> queryRoles(SyEmp syEmp) {
        return syEmpMapper.queryRoles(syEmp);
    }

    @Override
    public int queryExitPhone(String phone) {
        return syEmpMapper.queryExitPhone(phone);
    }

    @Override
    public SyEmp logInDx(String phone) {
        return syEmpMapper.logInDx(phone);
    }

    /**
     * 查询除了当前用户后的所有用户
     * @param id
     * 当前登录用户的ID
     * @return
     */
    @Override
    public List<SyEmp> querySyEmp(Integer id) {
        return syEmpMapper.querySyEmp(id);
    }


}
