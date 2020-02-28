package com.xr.bos.service.impl;

import com.xr.bos.dao.SyMenusMapper;
import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyMenus;
import com.xr.bos.service.SyMenusService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SyMenusServiceImpl implements SyMenusService {

    @Autowired
    private SyMenusMapper syMenusMapper;

    @Override
    public List<SyMenus> queryDaMoKuai(Integer syEmpID) {
        return syMenusMapper.queryDaMoKuai(syEmpID);
    }

    @Override
    public List<SyMenus> queryChild(Map<String, Object> map) {
        return syMenusMapper.queryChild(map);
    }

    @Override
    public List<SyMenus> findMenusAll() {
        return syMenusMapper.findMenusAll();
    }
    /**
     * 查询下拉框上级菜单
     * @return
     */
    @Override
    public List<SyMenus> selectedparent() {
        return syMenusMapper.selectedparent();
    }


    /**
     * 多条件查询
     */
    @Override
    public List<SyMenus> findMenusByparentIDAandText(SyMenus syMenus) {
        return syMenusMapper.findMenusByparentIDAandText(syMenus);
    }

    /**
     * 新增菜单
     * @param syMenus
     * @return
     */
    @Override
    public int addMenus(SyMenus syMenus) {
        return syMenusMapper.addMenus(syMenus);
    }

    /**
     * 修改页面赋值
     * @return
     */
    @Override
    public List<SyMenus> findMenusByID(SyMenus syMenus) {
        return syMenusMapper.findMenusByID(syMenus);
    }
    /**
     * 修改菜单
     * @param syMenus
     * @return
     */
    @Override
    public int updateMenus(SyMenus syMenus) {
        return syMenusMapper.updateMenus(syMenus);
    }

    /**
     * 删除菜单
     * @param ID
     * @return
     */
    @Override
    public int deleteMenus(Integer ID) {
        return syMenusMapper.deleteMenus(ID);
    }
}
