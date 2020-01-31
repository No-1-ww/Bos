package com.xr.bos.service;

import com.xr.bos.model.SorStorageDetails;

import java.util.List;

public interface SorStorageDetailsService {
    int addSorStorageDetails(SorStorageDetails sorStorageDetails);

    /**
     * 根据订单ID来查看订单详情
     * @param SID
     * @return
     */
    List<SorStorageDetails> queryByID(Integer SID);
}
