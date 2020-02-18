package com.xr.bos.service;



import com.xr.bos.model.Bigloglogisticscontroltable;

import java.util.List;
import java.util.Map;

public interface Bigloglogisticscontroltableservice {
    List<Bigloglogisticscontroltable> select(int page,int limit);
    List<Bigloglogisticscontroltable> selectwhere(String WorkSheetNo, String Corporation);
    Map<String,Object> selectmax();
     int insertBL(Bigloglogisticscontroltable blt);
}
