package com.xr.bos.service.impl;

import com.xr.bos.dao.BasZoneinfoMapper;
import com.xr.bos.service.BasZoneinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BasZoneinfoServiceImpl implements BasZoneinfoService {

    @Resource
    private BasZoneinfoMapper basZoneinfoMapper;

    @Override
    public List<Map<String, Object>> findZoneinfoAll() {
        return basZoneinfoMapper.findZoneinfoAll();
    }
}
