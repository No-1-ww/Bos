package com.xr.bos.dao;

import com.xr.bos.model.Dis_propagandatask;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 调度l--宣传任务
 */
@Repository
public interface PropagandataskMapper {
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
