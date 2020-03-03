package com.xr.bos.service.impl;

import com.xr.bos.dao.CancelSignApplicationMapper;
import com.xr.bos.service.CancelSignApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CancelSignApplicationImpl implements CancelSignApplicationService {

    @Autowired
    private CancelSignApplicationMapper cancelSignApplicationMapper;

    @Override
    public List<Map<String, Object>> queryall() {

        return cancelSignApplicationMapper.queryall();
    }
}
