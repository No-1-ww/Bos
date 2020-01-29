package com.xr.bos.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Acc_worksheetMapper {
    //查询
    List<Map<String,Object>> queryAcc_worksheetMapper();
}
