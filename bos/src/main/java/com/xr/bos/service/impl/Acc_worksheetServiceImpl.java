package com.xr.bos.service.impl;

import com.xr.bos.dao.Acc_worksheetMapper;
import com.xr.bos.model.Acc_worksheet;
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

    @Override
    public int add_worksheet(Acc_worksheet acc_worksheet) {
        return acc_worksheetMapper.add_worksheet(acc_worksheet);
    }

    @Override
    public String querywork_ID() {
        return acc_worksheetMapper.querywork_ID();
    }

    @Override
    public List<Acc_worksheet> querywhere_work(Acc_worksheet acc_worksheet) {
        return acc_worksheetMapper.querywhere_work(acc_worksheet);
    }

    @Override
    public Map<String, Object> queryByid_work(String workSheetNo) {
        return acc_worksheetMapper.queryByid_work(workSheetNo);
    }

}
