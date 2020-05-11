package com.xr.bos.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SorPackageMapper {
    //查询所有
    @Select("select * from sor_package sp order by sp.ID limit #{page},#{limit}")
    @Results(value = {
            @Result(column = "ID",property = "ID"),
            @Result(column = "PackagePerson",property = "PackagePerson"),
            @Result(column = "SealInt",property = "SealInt"),
            @Result(column = "Destination",property = "Destination"),
            @Result(column = "ReckonDes",property = "ReckonDes"),
            @Result(column = "TimeLimit",property = "TimeLimit"),
            @Result(column = "TicketSum",property = "TicketSum"),
            @Result(column = "CargoSum",property = "CargoSum"),
            @Result(column = "WeightSum",property = "WeightSum"),
            @Result(column = "VolumeSum",property = "VolumeSum"),
            @Result(column = "State",property = "State"),
            @Result(column = "Ask",property = "Ask")
    })
    List<Map<String,Object>> queryAllSorPackage(Map<String,Integer> map);

    @Select("select count(*) from sor_package")
    Integer queryAllCount();
}
