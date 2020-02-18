package com.xr.bos.dao;

import com.xr.bos.model.BasSubstitute;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BasSubstituteMapper extends Mapper<BasSubstitute> {

    //查询所有取派员设置
    List<Map<String,Object>> findBasSubstituteAll();
}