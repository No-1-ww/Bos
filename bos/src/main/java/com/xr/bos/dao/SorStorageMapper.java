package com.xr.bos.dao;

import com.xr.bos.model.SorStorage;
import com.xr.bos.model.SyEmp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SorStorageMapper {
     List<Map<String,Object>> queryAll();

     String queryMaxID();

     Integer addStorage(SorStorage sorStorage);


}
