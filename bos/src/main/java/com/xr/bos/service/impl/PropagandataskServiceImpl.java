package com.xr.bos.service.impl;

import com.xr.bos.dao.PropagandataskMapper;
import com.xr.bos.service.PropagandataskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PropagandataskServiceImpl implements PropagandataskService {

    @Autowired
    private PropagandataskMapper propagandataskMapper;

    @Override
    public List<Map<String, Object>> queryall() {
        return propagandataskMapper.queryall();
    }
}
