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
}
