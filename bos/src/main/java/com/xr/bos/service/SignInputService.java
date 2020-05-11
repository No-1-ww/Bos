package com.xr.bos.service;

import com.xr.bos.model.Dis_workordersign;

import java.util.List;
import java.util.Map;

/**
 * 调度的签收录入
 */
public interface SignInputService {
    //查询
    List<Map<String,Object>> queryall();

    //新增
    int addSig(Dis_workordersign dis_workordersign);
    //查询工作单号
    String query_gzd();

    //根据id查询
    Dis_workordersign queryById(String workSheetNo);

    //修改
    int update_Sig(Dis_workordersign dis_workordersign);
}
