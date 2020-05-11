package com.xr.bos.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SorPackageDetailsMapper {

    @Select("select * from sor_packagedetails where PackageID = #{packageID}")
    @Results(value = {
            @Result(column = "ID",property = "ID"),
            @Result(column = "PackageID",property = "PackageID"),
            @Result(column = "WareName",property = "WareName"),
            @Result(column = "Destination",property = "Destination"),
            @Result(column = "Ticket",property = "Ticket"),
            @Result(column = "ActualCargoInt",property = "ActualCargoInt"),
            @Result(column = "CargoInt",property = "CargoInt"),
            @Result(column = "Weight",property = "Weight"),
            @Result(column = "Volume",property = "Volume"),
            @Result(column = "Service",property = "Service"),
            @Result(column = "ImportantHints",property = "ImportantHints"),
            @Result(column = "Ask",property = "Ask"),
            @Result(column = "InputType",property = "InputType")
    })
    List<Map<String,Object>> queryPackageDetailsByID(String packageID);
}
