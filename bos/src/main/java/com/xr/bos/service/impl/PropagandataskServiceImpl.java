package com.xr.bos.service.impl;

import com.xr.bos.dao.PropagandataskMapper;
import com.xr.bos.model.Dis_propagandatask;
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

    @Override
    public int add_Pro(Dis_propagandatask dis_propagandatask) {
        return propagandataskMapper.add_Pro(dis_propagandatask);
    }

    @Override
    public Dis_propagandatask query_ById(int id) {
        return propagandataskMapper.query_ById(id);
    }

    @Override
    public int update_Pro(Dis_propagandatask dis_propagandatask) {
        return propagandataskMapper.update_Pro(dis_propagandatask);
    }


}
