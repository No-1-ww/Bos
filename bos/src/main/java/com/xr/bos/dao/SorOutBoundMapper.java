package com.xr.bos.dao;

import com.xr.bos.model.SorOutBound;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SorOutBoundMapper {

    //pageHelper失效暂时先用map集合page,limit代替
    List<Map<String,Object>> queryAll(Map<String,Integer> map);
    //查询所有
    Integer queryOutBoundCount();

    //查询最大的订单ID
    String queryMaxOutBoundID();

    //新增
    Integer addOutBound(SorOutBound sorOutBound);

    //修改
    Integer upDateOutBound(SorOutBound sorOutBound);

    //删除
    Integer deleteOutBound(String OutBoundID);

    //根据条件查询
    List<Map<String,Object>> queryWhere(Map<String,Object> map);

    //根据条件查询总数
    Integer queryWhereOutBoundCount(Map<String,Object> map);
}
