package com.xr.bos.dao;

import com.xr.bos.model.SyUnits;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SyUnitsMapper {

    /**
     * 根据ID来查询
     * @param ID
     * @return
     */
     SyUnits findID(Integer ID);


    //查询所有
    List<Map<String,Object>> findUntisAll();
    //根据单位名称查询单位资料
    List<Map<String,Object>> findUntiswhereAsname(String name);
}
