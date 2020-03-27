package com.xr.bos.service.impl;

import com.xr.bos.dao.SorCheckBoundMapper;
import com.xr.bos.service.SorCheckBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SorCheckBoundServiceImpl implements SorCheckBoundService {

    @Autowired
    private SorCheckBoundMapper sorCheckBoundMapper;

    @Override
    public List<Map<String, Object>> queryAllSorCheckBound(Map<String,Integer> map) {
        return sorCheckBoundMapper.queryAllSorCheckBound(map);
    }

    @Override
    public Integer querySorCheckBoundCount() {
        return sorCheckBoundMapper.querySorCheckBoundCount();
    }
}
