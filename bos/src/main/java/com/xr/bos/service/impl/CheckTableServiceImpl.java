package com.xr.bos.service.impl;

import com.xr.bos.dao.CheckTableMapper;
import com.xr.bos.service.CheckTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CheckTableServiceImpl implements CheckTableService {

    @Autowired
    private CheckTableMapper checkTableMapper;

    @Override
    public List<Map<String, Object>> queryall() {
        return checkTableMapper.queryall();
    }
}
