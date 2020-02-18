package com.xr.bos.service.impl;

import com.xr.bos.dao.BasPartitionMapper;
import com.xr.bos.service.BasPartitionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BasPartitionServiceImpl implements BasPartitionService {

    @Resource
    private BasPartitionMapper basPartitionMapper;

    @Override
    public List<Map<String, Object>> findpartitionAll() {
        return basPartitionMapper.findpartitionAll();
    }
}
