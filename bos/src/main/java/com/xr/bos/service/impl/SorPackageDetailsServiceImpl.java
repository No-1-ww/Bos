package com.xr.bos.service.impl;

import com.xr.bos.dao.SorPackageDetailsMapper;
import com.xr.bos.service.SorPackageDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SorPackageDetailsServiceImpl implements SorPackageDetailsService {

    @Autowired
    private SorPackageDetailsMapper sorPackageDetailsMapper;

    @Override
    public List<Map<String, Object>> queryPackageDetailsByID(String packageID) {
        return sorPackageDetailsMapper.queryPackageDetailsByID(packageID);
    }
}
