package com.xr.bos.service.impl;

import com.xr.bos.dao.SorOutBoundDetailsMapper;
import com.xr.bos.model.SorOutBoundDetails;
import com.xr.bos.service.SorOutBoundDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SorOutBoundDetailsServiceImpl implements SorOutBoundDetailsService {

    @Autowired
    private SorOutBoundDetailsMapper sorOutBoundDetailsMapper;

    @Override
    public int addSorOutBoundDetails(SorOutBoundDetails sorOutBoundDetails) {
        return sorOutBoundDetailsMapper.addSorOutBoundDetails(sorOutBoundDetails);
    }

    @Override
    public Integer deleteOutBoundDetails(String OutBoundID) {
        return sorOutBoundDetailsMapper.deleteOutBoundDetails(OutBoundID);
    }

    @Override
    public List<Map<String, Object>> queryByOutBoundID(String OutBoundID) {
        return sorOutBoundDetailsMapper.queryByOutBoundID(OutBoundID);
    }
}
