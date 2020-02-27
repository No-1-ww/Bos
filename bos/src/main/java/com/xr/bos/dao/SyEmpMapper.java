package com.xr.bos.dao;

import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyRoles;
import com.xr.bos.model.SyUnits;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SyEmpMapper {

    List<SyEmp> select();

    SyEmp logIn(String empNo);

    List<Map<String,Object>> queryRoles(SyEmp syEmp);


    //查询是否有该电话号码存在
    int queryExitPhone(String phone);

     SyEmp logInDx(String phone);

     //查询除去当前用户的所有用户
    List<SyEmp> querySyEmp(Integer id);


    //验证入库交接单
    SyEmp check(String empName);


    //查询所有员工，登录的人看不到自己的信息
    List<Map<String,Object>> findEmpAll(Integer id);

    /**
     * 多条件查询
     * @param syEmp
     * @return
     */
    List<Map<String,Object>> findEmpByNameOrDisabled(SyEmp syEmp);


    /**
     * 下拉框角色名 查询
     * @return
     */
    @Select("SELECT ID,RoleName from sy_roles")
    List<SyRoles> selectedRolesByRolesName();

    /**
     * 下拉框单位查询
     * @return
     */
    @Select("SELECT ID,Name from sy_units")
    List<SyUnits> selectedUntisByName();

    /**
     * 查询最大的工号
     * @return
     */
    @Select(" SELECT MAX(EmpNo) FROM sy_emp")
    String findMaxByEmpNo();

    /**
     * 新增员工
     * @param syEmp
     * @return
     */
    @Insert("INSERT INTO `bos`.`sy_emp`( `EmpName`, `EmpNo`, `Pwd`, `Phone`, `Photo`, `QueryPwd`, `RoleID`, `EmpUnit`, `Remark`, `Disabled`) VALUES (#{empName} , #{empNo} , MD5(#{pwd}),#{phone} ,#{photo} ,MD5(#{queryPwd}),#{roleID} , #{empUnit} ,#{remark} ,${disabled})")
    int addEmp(SyEmp syEmp);


    /**
     * 根据id查询
     * @param syEmp
     * @return
     */
    @Select("select e.ID, e.EmpName, e.EmpNo, e.Pwd, e.Phone, e.Photo, e.QueryPwd, e.RoleID, e.EmpUnit, e.Remark, e.Disabled from sy_emp e where e.ID=#{ID}")
    List<Map<String,Object>> findEmpByid(SyEmp syEmp);



    /**
     * 修改员工
     * @param syEmp
     * @return
     */
    @Update("UPDATE `bos`.`sy_emp` SET `EmpName` = #{empName} , `EmpNo` = #{empNo} , `Pwd` = MD5(#{pwd} ), `Phone` =#{phone} , `Photo` =#{photo} , `QueryPwd` = MD5(#{queryPwd}), `RoleID` =#{roleID} , `EmpUnit` = #{empUnit} , `Remark` = #{remark} , `Disabled` =${disabled} WHERE `ID` = #{ID} ")
    int updateEmp(SyEmp syEmp);

    /**
     * 删除员工
     * @return
     */
    @Delete("delete from sy_emp where ID=#{ID}")
    int deleteEmpByid(Integer ID);

}
