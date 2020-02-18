package com.xr.bos.service;

import java.util.List;
import java.util.Map;

public interface BasShuttlebusService{

    //查询所有班车
    List<Map<String,Object>> findBasShuttlebusAll();
}
