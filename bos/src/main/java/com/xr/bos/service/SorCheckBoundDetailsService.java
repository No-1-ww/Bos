package com.xr.bos.service;

import java.util.List;
import java.util.Map;

public interface SorCheckBoundDetailsService {
    //查询盘库详情
    List<Map<String,Object>> querySorCheckBoundDetailsByID(String ID);
}
