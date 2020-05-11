package com.xr.bos.service;

import java.util.List;
import java.util.Map;

public interface SorCheckBoundDetailsService {
    //查询盘库详情
    List<Map<String,Object>> querySorCheckBoundDetailsByID(String ID);

    //新增盘库详情单
    Integer addSorCheckBoundDetails(Map<String,Object> map);

    //删除所有详情
    Integer deleteCheckBoundDetails(String checkID);
}
