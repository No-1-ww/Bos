package com.xr.bos.service;

import com.xr.bos.model.SorCheckBound;

import java.util.List;
import java.util.Map;

public interface SorCheckBoundService {
    List<Map<String,Object>> queryAllSorCheckBound(Map<String,Integer> map);

    Integer querySorCheckBoundCount();

    String queryMaxID();

    //查询扫描设备号
    List<Map<String,Object>> queryScan();

    //新增盘库单
    Integer addSorCheckBound(SorCheckBound sorCheckBound);

    Map<String,Object> queryByID(String checkID);

    //修改
    Integer updateCheckBound(Map<String,Object> map);

    //删除
    Integer deleteCheckBound(String ID);

    //按条件查询
    List<Map<String,Object>> queryWhereSorCheckBound(Map<String,Object> map);

    //按条件查询总数
    Integer queryWhereSorCheckBoundCount(Map<String,Object> map);
}
