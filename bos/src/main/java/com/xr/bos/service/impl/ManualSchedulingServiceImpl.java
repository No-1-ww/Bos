package com.xr.bos.service.impl;

import com.xr.bos.dao.ManualSchedulingMapper;
import com.xr.bos.service.ManualSchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ManualSchedulingServiceImpl implements ManualSchedulingService {

    @Autowired
    private ManualSchedulingMapper manualSchedulingMapper;

    @Override
    public List<Map<String, Object>> queryall() {
        return manualSchedulingMapper.queryall();
    }

    @Override
    public List<Map<String, Object>> querywhere_manua(Map<String, Object> map) {
        return manualSchedulingMapper.querywhere_manua(map);
    }

    @Override
    public List<Map<String, Object>> query_ById(String jObNo) {
        return manualSchedulingMapper.query_ById(jObNo);
    }

    @Override
    public int del_manu(String jObNo) {
        return manualSchedulingMapper.del_manu(jObNo);
    }
}
