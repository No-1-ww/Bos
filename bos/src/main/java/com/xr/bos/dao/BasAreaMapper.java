package com.xr.bos.dao;

import com.xr.bos.model.BasArea;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BasAreaMapper extends Mapper<BasArea> {
    //查询区域设置
    List<Map<String,Object>> findBasAreaAll();

}