package com.xr.bos.service.impl;

import com.xr.bos.dao.BasShuttlebusMapper;
import com.xr.bos.service.BasShuttlebusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BasShuttlebusServiceImpl implements BasShuttlebusService {

    @Resource
    private BasShuttlebusMapper basShuttlebusMapper;

    @Override
    public List<Map<String, Object>> findBasShuttlebusAll() {
        return basShuttlebusMapper.findBasShuttlebusAll();
    }
}
