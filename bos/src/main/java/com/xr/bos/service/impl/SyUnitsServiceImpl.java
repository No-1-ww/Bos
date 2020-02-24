package com.xr.bos.service.impl;

import com.xr.bos.dao.SyUnitsMapper;
import com.xr.bos.model.SyUnits;
import com.xr.bos.service.SyUnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SyUnitsServiceImpl implements SyUnitsService {

    @Autowired
    private SyUnitsMapper syUnitsMapper;

    @Override
    public SyUnits findID(Integer ID) {
        return syUnitsMapper.findID(ID);
    }

    @Override
    public List<Map<String, Object>> findUntisAll() {
        return syUnitsMapper.findUntisAll();
    }

    //根据单位名称查询单位资料
    @Override
    public List<Map<String, Object>> findUntiswhereAsname(String name) {
        return syUnitsMapper.findUntiswhereAsname(name);
    }
}
