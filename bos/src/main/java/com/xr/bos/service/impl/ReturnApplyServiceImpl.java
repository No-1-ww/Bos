package com.xr.bos.service.impl;

import com.xr.bos.dao.ReturnApplyMapper;
import com.xr.bos.model.Ret_returnlist;
import com.xr.bos.service.ReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReturnApplyServiceImpl implements ReturnApplyService {

    @Autowired
    private ReturnApplyMapper returnApplyMapper;


    @Override
    public List<Map<String, Object>> queryall() {
        return returnApplyMapper.queryall();
    }

    @Override
    public int add_Apply(Ret_returnlist ret_returnlist) {
        return returnApplyMapper.add_Apply(ret_returnlist);
    }

    @Override
    public String query_ApplicationNo() {
        return returnApplyMapper.query_ApplicationNo();
    }

    @Override
    public String query_WorkSheetNo() {
        return returnApplyMapper.query_WorkSheetNo();
    }

    @Override
    public List<Ret_returnlist> query_empName() {
        return returnApplyMapper.query_empName();
    }

    @Override
    public List<Ret_returnlist> query_Name() {
        return returnApplyMapper.query_Name();
    }

    @Override
    public int del_retu(String applicationNo) {
        return returnApplyMapper.del_retu(applicationNo);
    }

    @Override
    public Map<String, Object> queryByid(String workSheetNo) {
        return returnApplyMapper.queryByid(workSheetNo);
    }

    @Override
    public List<Map<String, Object>> queryaConfim() {
        return returnApplyMapper.queryaConfim();
    }

    @Override
    public List<Map<String, Object>> queryProduce() {
        return returnApplyMapper.queryProduce();
    }
}
