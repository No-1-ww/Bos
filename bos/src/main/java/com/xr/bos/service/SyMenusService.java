package com.xr.bos.service;

import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyMenus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface SyMenusService {
    List<SyMenus> queryDaMoKuai(Integer syEmpID);

    List<SyMenus> queryChild(Map<String, Object> map);

    /**
     * 查询所有菜单信息
     * @return
     */
    List<SyMenus> findMenusAll();

    /**
     * 查询下拉框上级菜单
     * @return
     */
    List<SyMenus> selectedparent();

    /**
     * 多条件查询
     */
    List<SyMenus> findMenusByparentIDAandText(SyMenus syMenus);

    /**
     * 新增菜单
     * @param syMenus
     * @return
     */
   int addMenus(SyMenus syMenus);

    /**
     * 修改页面赋值
     * @return
     */
    List<SyMenus> findMenusByID(SyMenus syMenus);

    /**
     * 修改菜单
     * @param syMenus
     * @return
     */
   int updateMenus(SyMenus syMenus);

    /**
     * 删除菜单
     * @param ID
     * @return
     */
    int deleteMenus(Integer ID);


}
