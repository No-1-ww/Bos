package com.xr.bos.service;

import com.xr.bos.model.Acc_worksheet;

import java.util.List;
import java.util.Map;

public interface Acc_worksheetService {
    //查询
    List<Map<String,Object>> queryAcc_worksheetMapper();

    //新增
    int add_worksheet(Acc_worksheet acc_worksheet);

    //查询最大的工作单号
    String querywork_ID();

    //条件查询
    List<Acc_worksheet> querywhere_work(Acc_worksheet acc_worksheet);

    //根据id查询
    Map<String,Object> queryByid_work(String workSheetNo);

}
