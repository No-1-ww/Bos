package com.xr.bos.service.impl;

import com.xr.bos.dao.SyMenusMapper;
import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyMenus;
import com.xr.bos.service.SyMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SyMenusServiceImpl implements SyMenusService {

    @Autowired
    private SyMenusMapper syMenusMapper;

    @Override
    public List<SyMenus> queryDaMoKuai(Integer syEmpID) {
        return syMenusMapper.queryDaMoKuai(syEmpID);
    }

    @Override
    public List<SyMenus> queryChild(Map<String, Object> map) {
        return syMenusMapper.queryChild(map);
    }
}
