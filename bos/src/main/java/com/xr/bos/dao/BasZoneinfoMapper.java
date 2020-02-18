package com.xr.bos.dao;

import com.xr.bos.model.BasZoneinfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BasZoneinfoMapper extends Mapper<BasZoneinfo> {
    //查询定区管理
    List<Map<String,Object>> findZoneinfoAll();
}