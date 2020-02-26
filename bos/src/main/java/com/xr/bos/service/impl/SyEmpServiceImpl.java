package com.xr.bos.service.impl;

import com.xr.bos.dao.SyEmpMapper;
import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyRoles;
import com.xr.bos.model.SyUnits;
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

    @Override
    public SyEmp check(String empName) {
        return syEmpMapper.check(empName);
    }

    @Override
    public List<Map<String, Object>> findEmpAll(Integer id) {
        return syEmpMapper.findEmpAll(id);
    }


    /**
     * 多条件查询
     * @param syEmp
     * @return
     */
    @Override
    public List<Map<String, Object>> findEmpByNameOrDisabled(SyEmp syEmp) {
        return syEmpMapper.findEmpByNameOrDisabled(syEmp);
    }


    /**
     * 下拉框角色名 查询
     * @return
     */
    @Override
    public List<SyRoles> selectedRolesByRolesName() {
        return syEmpMapper.selectedRolesByRolesName();
    }

    /**
     * 下拉框单位查询
     * @return
     */
    @Override
    public List<SyUnits> selectedUntisByName() {
        return syEmpMapper.selectedUntisByName();
    }

    /**
     * 查询最大的工号
     * @return
     */
    @Override
    public String findMaxByEmpNo() {
        return syEmpMapper.findMaxByEmpNo();
    }


}
