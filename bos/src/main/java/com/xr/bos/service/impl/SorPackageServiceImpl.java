package com.xr.bos.service.impl;

import com.xr.bos.dao.SorPackageMapper;
import com.xr.bos.service.SorPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SorPackageServiceImpl implements SorPackageService {

    @Autowired
    private SorPackageMapper sorPackageMapper;

    @Override
    public List<Map<String, Object>> queryAllSorPackage(Map<String, Integer> map) {
        return sorPackageMapper.queryAllSorPackage(map);
    }

    @Override
    public Integer queryAllCount() {
        return sorPackageMapper.queryAllCount();
    }
}
