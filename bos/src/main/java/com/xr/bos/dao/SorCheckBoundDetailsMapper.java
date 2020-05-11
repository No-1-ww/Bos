package com.xr.bos.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SorCheckBoundDetailsMapper {
    //查询盘库详情
    List<Map<String,Object>> querySorCheckBoundDetailsByID(String ID);

    @Insert("insert into sor_checkbounddetails(CheckID,CargoCount,Weight,Volume,CargoType,Direction,StoragePerson,StorageDate) values(#{CheckID},#{CargoCount},#{Weight},#{Volume},#{CargoType},#{Direction},#{StoragePerson},#{StorageDate})")
    Integer addSorCheckBoundDetails(Map<String, Object> map);

    @Delete("delete from sor_checkbounddetails where CheckID=#{checkID}")
    Integer deleteCheckBoundDetails(String checkID);
}
