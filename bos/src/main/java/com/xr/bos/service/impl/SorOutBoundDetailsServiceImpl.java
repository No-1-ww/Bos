package com.xr.bos.service.impl;

import com.xr.bos.dao.SorOutBoundDetailsMapper;
import com.xr.bos.model.SorOutBoundDetails;
import com.xr.bos.service.SorOutBoundDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SorOutBoundDetailsServiceImpl implements SorOutBoundDetailsService {

    @Autowired
    private SorOutBoundDetailsMapper sorOutBoundDetailsMapper;

    @Override
    public int addSorOutBoundDetails(SorOutBoundDetails sorOutBoundDetails) {
        return sorOutBoundDetailsMapper.addSorOutBoundDetails(sorOutBoundDetails);
    }
}
