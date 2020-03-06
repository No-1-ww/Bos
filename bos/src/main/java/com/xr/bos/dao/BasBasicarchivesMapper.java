package com.xr.bos.dao;

import com.xr.bos.model.BasBasicarchives;
import com.xr.bos.model.BasBasicarchivesentry;
import com.xr.bos.model.SyEmp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BasBasicarchivesMapper {

    //查询基础设置
    List<Map<String,Object>> findBasBasicarchivesAll();


    /**
     * 多条件查询
     * @return
     */
    List<Map<String,Object>> findBasBasicarchivesByBasicFileNumberAndName(BasBasicarchives basicarchives);

    //查询操作人
    @Select("select ID,EmpName from sy_emp")
    List<SyEmp> findOperatorID();

    /**
     * 查看有没有详情信息
     * @param basicarchives
     * @return
     */
    @Select("SELECT  Grade from bas_basicarchives where ID=#{id}  ")
    String findBasicarchivesentryByOperatorId(BasBasicarchives basicarchives);

    /**
     * 根据登录的id查询登录人的单位名称
     *
     * @param
     * @return
     */
    @Select("SELECT e.EmpName,u.`Name` as Uname FROM sy_emp e,sy_units u where 1=1 and u.ID=e.EmpUnit and e.ID=#{ID} ")
    List<Map<String, Object>> findEmpNameAndUntisNameByID(Integer ID);

    /**
     * 查询最大编号
     * @return
     */
    @Select("SELECT MAX(BasicFileNumber) FROM bas_basicarchives")
    String findMaxBasicFileNumber();



    /**
     * 添加基础档案
     * @param basicarchives
     * @return
     */
    @Insert("INSERT INTO `bos`.`bas_basicarchives`( `BasicFileNumber`, `Name`, `Grade`, `OperatorID`, `OperationUnitID`, `Remarks`, `OperationTime`, `InvalidateMark`) VALUES (#{basicfilenumber} ,#{name} ,${grade}, #{operatorid} ,#{operationunitid} ,#{remarks} ,#{operationtime} ,1)")
    int addbasicArchives(BasBasicarchives basicarchives);

    /**
     *编辑页面查询
     * @return
     */
    @Select("select b.id,b.BasicFileNumber,b.Name as Bname,b.Grade,e.EmpName,u.`Name` as Uname,b.OperationTime,b.Remarks from bas_basicarchives b ,sy_emp e ,sy_units u where b.OperatorID=e.ID and b.OperationUnitID=u.ID and b.id=#{id} ")
    List<Map<String,Object>> findBasicarchivesById(Integer id);

    /**
     * 修改
     * @param basicarchives
     * @return
     */
    @Update("UPDATE `bos`.`bas_basicarchives` SET  `Name` =#{name}, `Grade` =${grade}, `Remarks` = #{remarks} , `InvalidateMark` =1 WHERE `ID` =#{id}")
    int updateBasicarchivesById(BasBasicarchives basicarchives);
}