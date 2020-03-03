package com.xr.bos.service;

import com.xr.bos.model.SorOutBoundDetails;

public interface SorOutBoundDetailsService {
    /**
     * 新增出库详情表
     * @param sorOutBoundDetails
     * @return
     */
    int addSorOutBoundDetails(SorOutBoundDetails sorOutBoundDetails);
}
