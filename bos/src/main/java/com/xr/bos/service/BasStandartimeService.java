package com.xr.bos.service;

import com.xr.bos.model.BasStandartime;
import com.xr.bos.model.SyUnits;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BasStandartimeService{
    //查询收派时间管理
    List<Map<String,Object>> findstandartimeAll();

    /**
     * 下拉框查询单位
     * @return
     */
    List<SyUnits> selectedFindUnitsName();

    /**
     * 多条件查询
     * @param standartime
     * @return
     */
    List<Map<String,Object>> findstandartimeByTimeNameAndSubordinateUnit( BasStandartime standartime);
}
