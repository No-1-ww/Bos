package com.xr.bos.service;

import com.xr.bos.model.SorOutBoundDetails;

import java.util.List;
import java.util.Map;

public interface SorOutBoundDetailsService {
    /**
     * 新增出库详情表
     * @param sorOutBoundDetails
     * @return
     */
    int addSorOutBoundDetails(SorOutBoundDetails sorOutBoundDetails);

    Integer deleteOutBoundDetails(String OutBoundID);

    /**
     * 根据订单号查询订单详情
     */
    List<Map<String,Object>> queryByOutBoundID(String OutBoundID);
}
