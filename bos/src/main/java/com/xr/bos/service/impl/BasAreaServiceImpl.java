package com.xr.bos.service.impl;

import com.xr.bos.dao.BasAreaMapper;
import com.xr.bos.service.BasAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BasAreaServiceImpl implements BasAreaService {

    @Resource
    private BasAreaMapper basAreaMapper;

    @Override
    public List<Map<String, Object>> findBasAreaAll() {
        return basAreaMapper.findBasAreaAll();
    }
}
