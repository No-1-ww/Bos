package com.xr.bos.dao;

import com.xr.bos.model.BasShuttlebus;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BasShuttlebusMapper extends Mapper<BasShuttlebus> {

    //查询所有班车
    List<Map<String,Object>> findBasShuttlebusAll();

}