package com.xr.bos.service.impl;

import com.xr.bos.dao.BasBasicarchivesMapper;
import com.xr.bos.service.BasBasicarchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BasBasicarchivesServiceImpl implements BasBasicarchivesService {

    @Autowired
    private BasBasicarchivesMapper basBasicarchivesMapper;

    @Override
    public List<Map<String, Object>> findBasBasicarchivesAll() {
        return basBasicarchivesMapper.findBasBasicarchivesAll();
    }
}
