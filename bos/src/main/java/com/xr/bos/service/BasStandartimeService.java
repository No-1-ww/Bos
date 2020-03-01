package com.xr.bos.service;

import com.xr.bos.model.BasStandartime;
import com.xr.bos.model.SyUnits;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 添加收派时间管理
     * @param basStandartime
     * @return
     */
   int addBastandartime(BasStandartime basStandartime);



    /**
     * 修改赋值 ，根据id查询
     * @param standartime
     * @return
     */
    List<Map<String,Object>> finddeliverytimeByID( BasStandartime standartime);

    /**
     * 修改收派时间
     * @param standartime
     * @return
     */
    int updateBasStandartime(BasStandartime standartime);

    /**
     * 删除收派时间
     * @param id
     * @return
     */
    int deleteBasStandartime(Integer id);
}
