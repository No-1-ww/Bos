package com.xr.bos.service;

import java.util.List;
import java.util.Map;

public interface SorPackageDetailsService {
    List<Map<String,Object>> queryPackageDetailsByID(String packageID);
}
