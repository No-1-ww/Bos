package com.xr.bos.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SorCheckBoundDetailsMapper {
    //查询盘库详情
    List<Map<String,Object>> querySorCheckBoundDetailsByID(String ID);
}
