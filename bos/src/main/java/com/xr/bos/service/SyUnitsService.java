package com.xr.bos.service;

import com.xr.bos.model.SyUnits;

import java.util.List;
import java.util.Map;

public interface SyUnitsService {
    SyUnits findID(Integer ID);

    //查询所有
    List<Map<String,Object>> findUntisAll();
    //根据单位名称查询单位资料
    List<Map<String,Object>> findUntiswhereAsname(String name);

}
