package com.xr.bos.service;

import com.xr.bos.model.SorStorage;
import com.xr.bos.model.SyEmp;

import java.util.List;
import java.util.Map;

public interface SorStorageService {
    List<Map<String,Object>> queryAll();

    String queryMaxID();

    Integer addStorage(SorStorage sorStorage);


}
