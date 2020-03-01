package com.xr.bos.service;

import java.util.List;
import java.util.Map;

public interface SorOutBoundService {
    List<Map<String,Object>> queryAll(Map<String,Integer> map);

    Integer queryOutBoundCount();
}
