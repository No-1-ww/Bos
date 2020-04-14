package com.xr.bos.service.impl;

import com.xr.bos.dao.SorOutBoundMapper;
import com.xr.bos.model.SorOutBound;
import com.xr.bos.service.SorOutBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SorOutBoundServiceImpl implements SorOutBoundService {

    @Autowired
    private SorOutBoundMapper sorOutBoundMapper;
    @Override
    public List<Map<String, Object>> queryAll(Map<String, Integer> map) {
        //传入map集合暂时代替pageHelper
        return sorOutBoundMapper.queryAll(map);
    }

    @Override
    public Integer queryOutBoundCount() {
        return sorOutBoundMapper.queryOutBoundCount();
    }

    @Override
    public String queryMaxOutBoundID() {
        return sorOutBoundMapper.queryMaxOutBoundID();
    }

    @Override
    public Integer addOutBound(SorOutBound sorOutBound) {
        return sorOutBoundMapper.addOutBound(sorOutBound);
    }

    @Override
    public Integer upDateOutBound(SorOutBound sorOutBound) {
        return sorOutBoundMapper.upDateOutBound(sorOutBound);
    }

    @Override
    public Integer deleteOutBound(String OutBoundID) {
        return sorOutBoundMapper.deleteOutBound(OutBoundID);
    }

    @Override
    public List<Map<String, Object>> queryWhere(Map<String, Object> map) {
        return sorOutBoundMapper.queryWhere(map);
    }

    @Override
    public Integer queryWhereOutBoundCount(Map<String, Object> map) {
        return sorOutBoundMapper.queryWhereOutBoundCount(map);
    }


}
