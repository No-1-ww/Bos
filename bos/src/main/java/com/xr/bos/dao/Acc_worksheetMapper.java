package com.xr.bos.dao;

import com.xr.bos.model.Acc_worksheet;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Acc_worksheetMapper {
    //查询
    List<Map<String,Object>> queryAcc_worksheetMapper();

    //新增
    int add_worksheet(Acc_worksheet acc_worksheet);

    //查询最大的工作单号
    String querywork_ID();
}