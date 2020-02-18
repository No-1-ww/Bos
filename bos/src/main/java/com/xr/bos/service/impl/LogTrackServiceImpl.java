package com.xr.bos.service.impl;

import com.xr.bos.dao.LogTrackMapper;
import com.xr.bos.service.LogTrackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LogTrackServiceImpl implements LogTrackService {

    @Resource
    private LogTrackMapper logTrackMapper;

}
