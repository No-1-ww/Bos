package com.xr.bos.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SorOutBoundDetailsMapper {

    //查询明细信息
    List<Map<String,Object>> queryAll();
}
