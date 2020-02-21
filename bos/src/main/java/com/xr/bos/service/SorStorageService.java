package com.xr.bos.service;

import com.xr.bos.model.SorStorage;
import com.xr.bos.model.SyEmp;

import java.util.List;
import java.util.Map;

public interface SorStorageService {
    List<Map<String,Object>> queryAll(int page,int limit);
    //查询总数
    Integer queryCount();


    List<Map<String,Object>> queryWhere(Map<String,Object> map);

    //根据条件查询Count
    Integer queryWhereCount(Map<String,Object> map);


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
