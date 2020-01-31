package com.xr.bos.service.impl;

import com.xr.bos.dao.SorStorageDetailsMapper;
import com.xr.bos.model.SorStorageDetails;
import com.xr.bos.service.SorStorageDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SorStorageDetailsServiceImpl implements SorStorageDetailsService {

    @Autowired
    private SorStorageDetailsMapper sorStorageDetailsMapper;


    @Override
    public int addSorStorageDetails(SorStorageDetails sorStorageDetails) {
        return sorStorageDetailsMapper.addSorStorageDetails(sorStorageDetails);
    }
}
