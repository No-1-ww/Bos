package com.xr.bos.service;

import org.apache.ibatis.annotations.Delete;

import java.util.List;
import java.util.Map;

public interface ManualSchedulingService {
    //查询
    List<Map<String,Object>> queryall();

    /**
     * 条件查询
     * @param map
     * @return
     */
    List<Map<String,Object>> querywhere_manua(Map<String,Object> map);

    /**
     * 根据id查询
     * @param jObNo
     * @return
     */
    List<Map<String,Object>> query_ById(String jObNo);

    /**
     * 删除消单
     * @param jObNo
     * @return
     */
    @Delete("DELETE from acc_workorder where jobNo=#{jobNo}")
    int del_manu(String jObNo);
}
