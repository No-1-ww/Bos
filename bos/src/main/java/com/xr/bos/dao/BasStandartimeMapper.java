package com.xr.bos.dao;

import com.xr.bos.model.BasStandartime;
import com.xr.bos.model.SyUnits;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BasStandartimeMapper extends Mapper<BasStandartime> {
    //查询收派时间管理
    List<Map<String,Object>> findstandartimeAll();

    /**
     * 下拉框查询单位
     * @return
     */
    @Select("select ID,Name from sy_units")
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
    @Insert("INSERT INTO `bos`.`bas_standartime`( `TimeName`, `SubordinateUnit`, `WorkingTime`, `ClosingTime`, `SaturdayWorkingTime`, `SaturdayClosingTime`, `SundayWorkingTime`, `SundayClosingTime`) VALUES (#{timename} ,#{subordinateunit} , #{workingtime} , #{closingtime} , #{saturdayworkingtime} , #{saturdayclosingtime} , #{sundayworkingtime} ,#{sundayclosingtime} )")
    int addBastandartime(BasStandartime basStandartime);

    /**
     * 修改赋值 ，根据id查询
     * @param standartime
     * @return
     */
    @Select("select * from bas_standartime where ID=#{id} ")
    List<Map<String,Object>> finddeliverytimeByID( BasStandartime standartime);

    /**
     * 修改收派时间
     * @param standartime
     * @return
     */
    @Update("UPDATE `bos`.`bas_standartime` SET `TimeName` =#{timename} , `SubordinateUnit` = #{subordinateunit} , `WorkingTime` =#{workingtime} , `ClosingTime` = #{closingtime} , `SaturdayWorkingTime` = #{saturdayworkingtime} , `SaturdayClosingTime` =#{saturdayclosingtime} , `SundayWorkingTime` = #{sundayworkingtime} , `SundayClosingTime` = #{sundayclosingtime}  WHERE `ID` =#{id} ")
    int updateBasStandartime(BasStandartime standartime);

    /**
     * 删除收派时间
     * @param id
     * @return
     */
    @Delete("delete from bas_standartime where ID=#{id} ")
    int deleteBasStandartime(Integer id);


}