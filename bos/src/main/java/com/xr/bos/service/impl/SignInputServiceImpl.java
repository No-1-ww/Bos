package com.xr.bos.service.impl;

import com.xr.bos.dao.SignInputMapper;
import com.xr.bos.service.SignInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * 调度的签收录入
 */
@Service
public class SignInputServiceImpl implements SignInputService {

    @Autowired
    private SignInputMapper signInputMapper;

    @Override
    public List<Map<String, Object>> queryall() {
        return signInputMapper.queryall();
    }
}
