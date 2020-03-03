package com.xr.bos.dao;

import com.xr.bos.model.SorOutBoundDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SorOutBoundDetailsMapper {

    //查询明细信息
    List<Map<String,Object>> queryAll();

    /**
     * 新增出库详情表
     * @param sorOutBoundDetails
     * @return
     */
    int addSorOutBoundDetails(SorOutBoundDetails sorOutBoundDetails);
}
