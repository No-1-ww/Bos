package com.xr.bos.service.impl;

import com.xr.bos.dao.SyUnitsMapper;
import com.xr.bos.model.SyUnits;
import com.xr.bos.service.SyUnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyUnitsServiceImpl implements SyUnitsService {

    @Autowired
    private SyUnitsMapper syUnitsMapper;

    @Override
    public SyUnits findID(Integer ID) {
        return syUnitsMapper.findID(ID);
    }
}
