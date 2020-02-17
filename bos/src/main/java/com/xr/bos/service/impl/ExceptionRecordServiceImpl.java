package com.xr.bos.service.impl;

import com.xr.bos.dao.ExceptionRecordMapper;
import com.xr.bos.model.ExceptionRecord;
import com.xr.bos.service.ExceptionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionRecordServiceImpl implements ExceptionRecordService {

    @Autowired
    private ExceptionRecordMapper exceptionRecordMapper;

    @Override
    public int addExceptionRecord(ExceptionRecord exceptionRecord) {
        return exceptionRecordMapper.addExceptionRecord(exceptionRecord);
    }
}
