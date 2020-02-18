package com.xr.bos.service.impl;

import com.xr.bos.dao.BasStandartimeMapper;
import com.xr.bos.service.BasStandartimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BasStandartimeServiceImpl implements BasStandartimeService {

    @Resource
    private BasStandartimeMapper basStandartimeMapper;

    @Override
    public List<Map<String, Object>> findstandartimeAll() {
        return basStandartimeMapper.findstandartimeAll();
    }
}
