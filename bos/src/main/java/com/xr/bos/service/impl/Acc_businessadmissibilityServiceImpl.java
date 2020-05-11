package com.xr.bos.service.impl;


import com.xr.bos.dao.Acc_businessadmissibilityMapper;
import com.xr.bos.model.Acc_businessadmissibility;
import com.xr.bos.service.Acc_businessadmissibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Acc_businessadmissibilityServiceImpl implements Acc_businessadmissibilityService {

   @Autowired
   private Acc_businessadmissibilityMapper acc_businessadmissibilityMapper;


    @Override
    public List<Map<String, Object>> queryall() {
        return acc_businessadmissibilityMapper.queryall();
    }

    /* @Override
        public Integer totalAcc_admin() {
            return acc_businessadmissibilityMapper.totalAcc_admin();
        }
    */
    @Override
    public int addBusin(Acc_businessadmissibility acc_businessadmissibility) {
        return acc_businessadmissibilityMapper.addBusin(acc_businessadmissibility);
    }

    @Override
    public String querybusinNo_ID() {
        return acc_businessadmissibilityMapper.querybusinNo_ID();
    }

    @Override
    public String query_customCode() {
        return acc_businessadmissibilityMapper.query_customCode();
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
    public int updateAcc(Acc_businessadmissibility acc_businessadmissibility) {
        return acc_businessadmissibilityMapper.updateAcc(acc_businessadmissibility);
    }

    @Override
    public List<Map<String,Object>> query_whereAcc(Acc_businessadmissibility acc_businessadmissibility) {
        return acc_businessadmissibilityMapper.query_whereAcc(acc_businessadmissibility);
    }

    @Override
    public int update_afterSingleNum(String businessNoticeNo) {
        return acc_businessadmissibilityMapper.update_afterSingleNum(businessNoticeNo);
    }

    @Override
    public int deletAcc(String businessNoticeNo) {
        return acc_businessadmissibilityMapper.deletAcc(businessNoticeNo);
    }


}
