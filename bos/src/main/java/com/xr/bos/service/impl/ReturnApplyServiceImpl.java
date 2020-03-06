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
    public List<Map<String, Object>> queryaConfim() {
        return returnApplyMapper.queryaConfim();
    }

    @Override
    public List<Map<String, Object>> queryProduce() {
        return returnApplyMapper.queryProduce();
    }
}
