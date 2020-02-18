package com.xr.bos.service;

import java.util.List;
import java.util.Map;

public interface BasPartitionService{

    //查询分区管理 所有
    List<Map<String,Object>> findpartitionAll();
}
