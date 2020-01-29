package com.xr.bos.service.impl;

import com.xr.bos.dao.Acc_worksheetMapper;
import com.xr.bos.service.Acc_worksheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Acc_worksheetServiceImpl implements Acc_worksheetService {

    @Autowired
    private Acc_worksheetMapper acc_worksheetMapper;

    @Override
    public List<Map<String, Object>> queryAcc_worksheetMapper() {
        return acc_worksheetMapper.queryAcc_worksheetMapper();
    }
}
