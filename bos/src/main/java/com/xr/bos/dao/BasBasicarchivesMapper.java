package com.xr.bos.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BasBasicarchivesMapper {

    //查询基础设置
    List<Map<String,Object>> findBasBasicarchivesAll();
}