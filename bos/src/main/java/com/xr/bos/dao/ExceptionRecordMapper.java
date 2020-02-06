package com.xr.bos.dao;

import com.xr.bos.model.ExceptionRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRecordMapper {

    int addExceptionRecord(ExceptionRecord exceptionRecord);
}
