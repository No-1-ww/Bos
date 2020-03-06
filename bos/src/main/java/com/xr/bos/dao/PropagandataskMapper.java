package com.xr.bos.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 调度l--宣传任务
 */
@Repository
public interface PropagandataskMapper {
    //查询
    List<Map<String,Object>> queryall();
}
