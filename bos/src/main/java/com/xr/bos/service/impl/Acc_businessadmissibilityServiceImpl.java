package com.xr.bos.service.impl;


import com.xr.bos.dao.Acc_businessadmissibilityMapper;
import com.xr.bos.model.Acc_businessadmissibility;
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

    @Override
    public int addBusin(Acc_businessadmissibility acc_businessadmissibility) {
        return acc_businessadmissibilityMapper.addBusin(acc_businessadmissibility);
    }

    @Override
    public String querybusinNo_ID() {
        return acc_businessadmissibilityMapper.querybusinNo_ID();
    }

    @Override
    public List<Acc_businessadmissibility> query_importantHints() {
        return acc_businessadmissibilityMapper.query_importantHints();
    }

    @Override
    public Acc_businessadmissibility queryByIDbusinessNoticeNo(String businessNoticeNo) {
        return acc_businessadmissibilityMapper.queryByIDbusinessNoticeNo(businessNoticeNo);
    }

    @Override
    public List<Acc_businessadmissibility> query_whereAcc(String businessNoticeNo, String customCode) {
        return acc_businessadmissibilityMapper.query_whereAcc(businessNoticeNo,customCode);
    }


}
