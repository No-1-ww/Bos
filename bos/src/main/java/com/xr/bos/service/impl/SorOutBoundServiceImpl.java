package com.xr.bos.service.impl;

import com.xr.bos.dao.SorOutBoundMapper;
import com.xr.bos.service.SorOutBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SorOutBoundServiceImpl implements SorOutBoundService {

    @Autowired
    private SorOutBoundMapper sorOutBoundMapper;
    @Override
    public List<Map<String, Object>> queryAll(Map<String, Integer> map) {
        //传入map集合暂时代替pageHelper
        return sorOutBoundMapper.queryAll(map);
    }

    @Override
    public Integer queryOutBoundCount() {
        return sorOutBoundMapper.queryOutBoundCount();
    }
}
