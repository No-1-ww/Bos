package com.xr.bos.service.impl;

import com.xr.bos.dao.BasDeliverystandardMapper;
import com.xr.bos.service.BasDeliverystandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BasDeliverystandardServiceImpl implements BasDeliverystandardService {

    @Autowired
    private BasDeliverystandardMapper deliverystandardMapper;

    @Override
    public List<Map<String, Object>> findBasDeliverystandardAll() {
        return deliverystandardMapper.findBasDeliverystandardAll();
    }
}
