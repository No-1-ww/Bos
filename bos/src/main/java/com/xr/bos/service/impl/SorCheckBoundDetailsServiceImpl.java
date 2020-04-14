package com.xr.bos.service.impl;

import com.xr.bos.dao.SorCheckBoundDetailsMapper;
import com.xr.bos.service.SorCheckBoundDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SorCheckBoundDetailsServiceImpl implements SorCheckBoundDetailsService {

    @Autowired
    private SorCheckBoundDetailsMapper sorCheckBoundDetailsMapper;

    @Override
    public List<Map<String, Object>> querySorCheckBoundDetailsByID(String ID) {
        return sorCheckBoundDetailsMapper.querySorCheckBoundDetailsByID(ID);
    }
}
