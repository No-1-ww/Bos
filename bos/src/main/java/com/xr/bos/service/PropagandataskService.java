package com.xr.bos.service;

import com.xr.bos.model.Dis_propagandatask;

import java.util.List;
import java.util.Map;

public interface PropagandataskService {
    /**
     * 查询
     * @return
     */
    List<Map<String,Object>> queryall();

    /**
     * 新增
     * @param dis_propagandatask
     * @return
     */
    int add_Pro(Dis_propagandatask dis_propagandatask);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Dis_propagandatask query_ById(int id);

    /**
     * 修改
     * @param dis_propagandatask
     * @return
     */
    int update_Pro(Dis_propagandatask dis_propagandatask);
}
