package com.xr.bos.service.impl;


import com.xr.bos.dao.Acc_businessadmissibilityMapper;
import com.xr.bos.service.Acc_businessadmissibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Acc_businessadmissibilityServiceImpl implements Acc_businessadmissibilityService {

   @Autowired
   private Acc_businessadmissibilityMapper acc_businessadmissibilityMapper;

    @Override
    public List<Map<String,Object>> queryAcc_businessadmissibility() {
        return acc_businessadmissibilityMapper.queryAcc_businessadmissibility();
    }
}
