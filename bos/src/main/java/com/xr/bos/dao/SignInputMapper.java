package com.xr.bos.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 调度的签收录入
 */
@Repository
public interface SignInputMapper {
    //查询
    List<Map<String,Object>> queryall();
}
