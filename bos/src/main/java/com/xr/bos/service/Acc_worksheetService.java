package com.xr.bos.service;

import com.xr.bos.model.Acc_worksheet;

import java.util.List;
import java.util.Map;

public interface Acc_worksheetService {
    //查询
    List<Map<String,Object>> queryall();

    //新增
    int add_worksheet(Acc_worksheet acc_worksheet);

    //查询最大的工作单号
    String querywork_ID();

    //条件查询
    List<Map<String,Object>> querywhere_work(Map<String,Object> map);

    //根据id查询
    Map<String,Object> queryByid_work(String workSheetNo);

    /**
     * 工作单查询的修改需要
     * 两个修改方法，执行的多条SQL语句
     * @param
     * @return
     */
    int updateDestination(Map<String,Object> map);
    int updateimportantHints(Map<String,Object> map);
}
