package com.xr.bos.dao;

import com.xr.bos.model.SorCheckBound;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@ResponseBody
public interface SorCheckBoundMapper {

    List<Map<String,Object>> queryAllSorCheckBound(Map<String,Integer> map);

    Integer querySorCheckBoundCount();

    String queryMaxID();

    //查询扫描设备号
    List<Map<String,Object>> queryScan();

    Integer addSorCheckBound(SorCheckBound sorCheckBound);


    Map<String,Object> queryByID(String checkID);

    //修改
    @Update("update sor_checkbound set CargoSum = #{CargoSum},CheckPerson = #{CheckPerson},CheckCompany = #{CheckCompany} where ID = #{checkID}")
    Integer updateCheckBound(Map<String,Object> map);

    //删除
    @Delete("delete from sor_checkbound where ID = #{ID}")
    Integer deleteCheckBound(String ID);

    //按条件查询
    List<Map<String,Object>> queryWhereSorCheckBound(Map<String,Object> map);


    //按条件查询总数
    Integer queryWhereSorCheckBoundCount(Map<String,Object> map);

}
