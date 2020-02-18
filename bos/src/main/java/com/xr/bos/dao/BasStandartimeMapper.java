package com.xr.bos.dao;

import com.xr.bos.model.BasStandartime;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BasStandartimeMapper extends Mapper<BasStandartime> {
    //查询收派时间管理
    List<Map<String,Object>> findstandartimeAll();
}