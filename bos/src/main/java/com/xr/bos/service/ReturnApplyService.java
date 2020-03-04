package com.xr.bos.service;

import com.xr.bos.model.Ret_returnlist;

import java.util.List;
import java.util.Map;

public interface ReturnApplyService {
    //查询
    List<Map<String,Object>> queryall();

    List<Map<String,Object>> queryaConfim();

    //生成返货确认
    List<Map<String,Object>> queryProduce();
}
