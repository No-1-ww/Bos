package com.xr.bos.service.impl;

import com.xr.bos.dao.SignInputMapper;
import com.xr.bos.model.Dis_workordersign;
import com.xr.bos.service.SignInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * 调度的签收录入
 */
@Service
public class SignInputServiceImpl implements SignInputService {

    @Autowired
    private SignInputMapper signInputMapper;

    @Override
    public List<Map<String, Object>> queryall() {
        return signInputMapper.queryall();
    }

    @Override
    public int addSig(Dis_workordersign dis_workordersign) {
        return signInputMapper.addSig(dis_workordersign);
    }

    @Override
    public String query_gzd() {
        return signInputMapper.query_gzd();
    }

    @Override
    public Dis_workordersign queryById(String workSheetNo) {
        return signInputMapper.queryById(workSheetNo);
    }

    @Override
    public int update_Sig(Dis_workordersign dis_workordersign) {
        return signInputMapper.update_Sig(dis_workordersign);
    }
}
