package com.xr.bos.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xr.bos.dao.BasBasicarchivesentryMapper;
import com.xr.bos.service.BasBasicarchivesentryService;

import java.util.List;
import java.util.Map;

@Service
public class BasBasicarchivesentryServiceImpl implements BasBasicarchivesentryService{

    @Resource
    private BasBasicarchivesentryMapper basBasicarchivesentryMapper;



    /**
     * 查询详情信息
     * @param id
     * @return
     */
    @Override
    public List<Map<String, Object>> findBasicarchivesentryAll(Integer id) {
        return basBasicarchivesentryMapper.findBasicarchivesentryAll(id);
    }
}
