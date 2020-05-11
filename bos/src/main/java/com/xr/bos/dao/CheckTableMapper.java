package com.xr.bos.dao;

import com.xr.bos.model.Acc_businessadmissibility;
import com.xr.bos.model.Acc_workorder;
import com.xr.bos.model.CheckTable;
import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CheckTableMapper {

    /**
     * 查询所有
     * @return
     */
    List<Map<String,Object>> queryall();

    /**
     * 条件查询
     * @return
     */
    List<Map<String,Object>> querywhere(Map<String,Object> map);

    /**
     * 根据id查询
     * @param jObNo
     * @return
     */
    CheckTable query_ById(String jObNo);

    /**
     * 查询小件员下拉框
     * @return
     */
    List<CheckTable> query_xjy();

    /**
     * 查询单位下拉框
     * @return
     */
    List<CheckTable> query_dw();

    /**
     * 修改
     * @param map
     * @return
     */
    int update_Sign(Map<String,Object> map);
}
