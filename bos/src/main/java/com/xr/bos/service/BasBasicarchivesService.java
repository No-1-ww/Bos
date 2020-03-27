package com.xr.bos.service;

import com.xr.bos.model.BasBasicarchives;
import com.xr.bos.model.BasBasicarchivesentry;
import com.xr.bos.model.SyEmp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface BasBasicarchivesService{
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
    String findBasicarchivesentryByOperatorId(BasBasicarchives basicarchives);

    /**
     * 根据登录的id查询登录人的单位名称
     *
     * @param
     * @return
     */
   List<Map<String, Object>> findEmpNameAndUntisNameByID(Integer ID);

    /**
     * 添加基础档案
     * @param basicarchives
     * @return
     */
   int addbasicArchives(BasBasicarchives basicarchives);

    /**
     * 查询最大编号
     * @return
     */
    String findMaxBasicFileNumber();

    /**
     *编辑页面查询
     * @return
     */
  List<Map<String,Object>> findBasicarchivesById(Integer id);

    /**
     * 修改
     * @param basicarchives
     * @return
     */
    int updateBasicarchivesById(BasBasicarchives basicarchives);


    /**
     * 查询主表下有没有条目信息
     * @param id
     * @return
     */
   String findbas_basicarchivesentryByParent(Integer id);

    /**
     * 删除基础设置
     * @param id
     * @return
     */
   int deletebasicarchivesByID(Integer id);

}
