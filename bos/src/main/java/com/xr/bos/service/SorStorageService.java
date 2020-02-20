package com.xr.bos.service;

import com.xr.bos.model.SorStorage;
import com.xr.bos.model.SyEmp;

import java.util.List;
import java.util.Map;

public interface SorStorageService {
    List<Map<String,Object>> queryAll();


    List<Map<String,Object>> queryWhere(SorStorage sorStorage);


    String queryMaxID();

    Integer addStorage(SorStorage sorStorage);


    /**
     * 根据ID查询
     */
    Map<String,Object> queryByIDStorage(Integer ID);

    /**
     * 修改
     */
    Integer updateStorage(SorStorage sorStorage);

    /**
     * 删除
     */
    Integer deleteSorStorage(Integer ID);


}
