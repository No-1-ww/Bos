package com.xr.bos.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BasBasicarchivesentryService{

    /**
     * 查询详情信息
     * @param id
     * @return
     */
   List<Map<String,Object>> findBasicarchivesentryAll(Integer id);
}
