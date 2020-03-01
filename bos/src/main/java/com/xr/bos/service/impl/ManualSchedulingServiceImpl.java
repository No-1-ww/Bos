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
}
