package com.xr.bos.dao;

import com.xr.bos.model.Ret_returnlist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 返货
 * 返货申请
 * 分货申请确认
 * 生成返货单
 */
@Repository
public interface ReturnApplyMapper {
    //返货申请
    List<Map<String,Object>> queryall();

    //返货货申请确认
    List<Map<String,Object>> queryaConfim();

    //生成返货确认
    List<Map<String,Object>> queryProduce();

}
