package com.xr.bos.service.impl;

import com.xr.bos.dao.SorCheckBoundMapper;
import com.xr.bos.model.SorCheckBound;
import com.xr.bos.service.SorCheckBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SorCheckBoundServiceImpl implements SorCheckBoundService {

    @Autowired
    private SorCheckBoundMapper sorCheckBoundMapper;

    @Override
    public List<Map<String, Object>> queryAllSorCheckBound(Map<String,Integer> map) {
        return sorCheckBoundMapper.queryAllSorCheckBound(map);
    }

    @Override
    public Integer querySorCheckBoundCount() {
        return sorCheckBoundMapper.querySorCheckBoundCount();
    }

    @Override
    public String queryMaxID() {
        return sorCheckBoundMapper.queryMaxID();
    }

    @Override
    public List<Map<String, Object>> queryScan() {
        return sorCheckBoundMapper.queryScan();
    }

    @Override
    public Integer addSorCheckBound(SorCheckBound sorCheckBound) {
        return sorCheckBoundMapper.addSorCheckBound(sorCheckBound);
    }

    @Override
    public Map<String, Object> queryByID(String checkID) {
        return sorCheckBoundMapper.queryByID(checkID);
    }

    @Override
    public Integer updateCheckBound(Map<String, Object> map) {
        return sorCheckBoundMapper.updateCheckBound(map);
    }

    @Override
    public Integer deleteCheckBound(String ID) {
        return sorCheckBoundMapper.deleteCheckBound(ID);
    }

    @Override
    public List<Map<String, Object>> queryWhereSorCheckBound(Map<String, Object> map) {
        return sorCheckBoundMapper.queryWhereSorCheckBound(map);
    }

    @Override
    public Integer queryWhereSorCheckBoundCount(Map<String, Object> map) {
        return sorCheckBoundMapper.queryWhereSorCheckBoundCount(map);
    }
}
