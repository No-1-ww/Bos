package com.xr.bos.service.impl;

import com.xr.bos.dao.CheckTableMapper;
import com.xr.bos.model.Acc_businessadmissibility;
import com.xr.bos.model.Acc_workorder;
import com.xr.bos.model.CheckTable;
import com.xr.bos.service.CheckTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CheckTableServiceImpl implements CheckTableService {

    @Autowired
    private CheckTableMapper checkTableMapper;

    @Override
    public List<Map<String, Object>> queryall() {
        return checkTableMapper.queryall();
    }

    @Override
    public List<Map<String, Object>> querywhere(Map<String,Object> map) {
        return checkTableMapper.querywhere(map);
    }

    @Override
    public CheckTable query_ById(String jObNo) {
        return checkTableMapper.query_ById(jObNo);
    }

    @Override
    public List<CheckTable> query_xjy() {
        return checkTableMapper.query_xjy();
    }

    @Override
    public List<CheckTable> query_dw() {
        return checkTableMapper.query_dw();
    }

    @Override
    public int update_Sign(Map<String,Object> map) {
        return checkTableMapper.update_Sign(map);
    }
}
