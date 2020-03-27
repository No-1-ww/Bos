package com.xr.bos.service;

import com.xr.bos.model.SorOutBound;

import java.util.List;
import java.util.Map;

public interface SorOutBoundService {
    List<Map<String,Object>> queryAll(Map<String,Integer> map);

    Integer queryOutBoundCount();

    //查询最大的ID
    String queryMaxOutBoundID();

    Integer addOutBound(SorOutBound sorOutBound);

    //修改
    Integer upDateOutBound(SorOutBound sorOutBound);

    Integer deleteOutBound(String OutBoundID);

    //根据条件查询
    List<Map<String,Object>> queryWhere(Map<String,Object> map);
    //根据条件查询总数
    Integer queryWhereOutBoundCount(Map<String,Object> map);
}
