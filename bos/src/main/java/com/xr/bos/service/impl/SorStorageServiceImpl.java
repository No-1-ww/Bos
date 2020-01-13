package com.xr.bos.service.impl;

import com.xr.bos.dao.SorStorageMapper;
import com.xr.bos.model.SorStorage;
import com.xr.bos.model.SyEmp;
import com.xr.bos.service.SorStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SorStorageServiceImpl implements SorStorageService {

    @Autowired
    private SorStorageMapper sorStorageMapper;

    @Override
    public List<Map<String,Object>> queryAll() {
        return sorStorageMapper.queryAll();
    }

    @Override
    public String queryMaxID() {
        return sorStorageMapper.queryMaxID();
    }

    @Override
    public Integer addStorage(SorStorage sorStorage){
        return sorStorageMapper.addStorage(sorStorage);
    }


}
