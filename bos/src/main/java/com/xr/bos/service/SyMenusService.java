package com.xr.bos.service;

import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyMenus;

import java.util.List;
import java.util.Map;

public interface SyMenusService {
    List<SyMenus> queryDaMoKuai(Integer syEmpID);

    List<SyMenus> queryChild(Map<String, Object> map);

    List<SyMenus> findMenusAll();
}
