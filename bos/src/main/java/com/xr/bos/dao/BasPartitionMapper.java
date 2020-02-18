package com.xr.bos.dao;

import com.xr.bos.model.BasPartition;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BasPartitionMapper extends Mapper<BasPartition> {
    //查询分区管理 所有
    List<Map<String,Object>> findpartitionAll();

}