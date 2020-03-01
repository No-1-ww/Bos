package com.xr.bos.dao;

import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyMenus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SyMenusMapper {
    /**
     * 根据登录的用户所拥有的角色查询出所有的大模块
     * @return
     */
    List<SyMenus> queryDaMoKuai(Integer syEmpID);
    //select m.* from sy_emp e,sy_roles r,sy_menus m,sy_rolesmenus rm where e.ID = 1 and e.RoleID = r.ID and r.ID = rm.RoleID and rm.MenuID = m.ID and parentID = 0
    /**
     * 根据大模块ID作为上一级ID来查询子菜单
     * 一二级别菜单都用这个方法来实现
     * @param map
     * @return
     */
    List<SyMenus> queryChild(Map<String, Object> map);
    //parmettype Integer
    //select m.* from sy_emp e,sy_roles r,sy_menus m,sy_rolesmenus rm
    // where e.ID = 1 and e.RoleID = r.ID and r.ID = rm.RoleID and rm.MenuID = m.ID and parentID = #{parentID}

    //查询所有菜单

    // select  s.id as ID,
    // (SELECT text from sy_menus WHERE s.parentID = ID) as shangjilanmu,
    // s.type,s.text,s.url,s.tip from sy_menus s
    List<SyMenus> findMenusAll();


    /**
     * 查询下拉框上级菜单
     * @return
     */
    @Select("select ID,text from sy_menus")
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
    @Insert("INSERT INTO `bos`.`sy_menus`( `parentID`, `type`, `text`, `url`, `tip`, `icon`) VALUES ( #{parentID} , #{type} , #{text} , #{url} , #{tip}, #{icon} )")
    int addMenus(SyMenus syMenus);

    /**
     * 修改页面赋值
     * @return
     */
    @Select("select * from sy_menus where ID=#{ID} ")
    List<SyMenus> findMenusByID(SyMenus syMenus);

    /**
     * 修改菜单
     * @param syMenus
     * @return
     */
    @Update("UPDATE `bos`.`sy_menus` SET `parentID` = #{parentID} , `type` = #{type} , `text` = #{text} , `url` = #{url} , `tip` = #{tip} , `icon` = #{icon}  WHERE `ID` =#{ID} ")
    int updateMenus(SyMenus syMenus);

    /**
     * 删除菜单
     * @param ID
     * @return
     */
    @Delete("delete from sy_menus where ID=#{ID} ")
    int deleteMenus(Integer ID);

}
