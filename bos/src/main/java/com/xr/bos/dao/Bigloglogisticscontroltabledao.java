package com.xr.bos.dao;

import com.xr.bos.model.Bigloglogisticscontroltable;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Bigloglogisticscontroltabledao {
    List<Bigloglogisticscontroltable> select(int page,int limit);
    List<Bigloglogisticscontroltable> selectwhere(@Param("WorkSheetNo") String WorkSheetNo, @Param("Corporation") String Corporation);
    Map<String,Object> selectmax();
     int insertBL(Bigloglogisticscontroltable blt);
}
