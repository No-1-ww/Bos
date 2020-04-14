package com.xr.bos.service;

import java.util.List;
import java.util.Map;

public interface SorCheckBoundService {
    List<Map<String,Object>> queryAllSorCheckBound(Map<String,Integer> map);

    Integer querySorCheckBoundCount();
}
