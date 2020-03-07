package com.xr.bos.service.impl;

import com.xr.bos.dao.BasSubstituteMapper;
import com.xr.bos.service.BasSubstituteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BasSubstituteServiceImpl implements BasSubstituteService {

    @Resource
    private BasSubstituteMapper basSubstituteMapper;

    @Override
    public List<Map<String, Object>> findBasSubstituteAll() {
        System.out.println("findBasSubstituteAllService");
        return basSubstituteMapper.findBasSubstituteAll();
    }
}
