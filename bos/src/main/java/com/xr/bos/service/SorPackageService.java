package com.xr.bos.service;

import java.util.List;
import java.util.Map;

public interface SorPackageService {

    List<Map<String,Object>> queryAllSorPackage(Map<String,Integer> map);

    Integer queryAllCount();

}
