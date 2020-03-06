package com.xr.bos.dao;

import com.xr.bos.model.BasBasicarchivesentry;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BasBasicarchivesentryMapper extends Mapper<BasBasicarchivesentry> {

    /**
     * 查询详情信息
     * @param id
     * @return
     */
    @Select(" SELECT y.ID,y.`Name` as Yname,s.BasicFileNumber,y.Available,e.EmpName  ,u.`Name` as Uname,y.OperationTime,y.Remarks FROM bas_basicarchivesentry y,bas_basicarchives s,sy_emp e ,sy_units u where y.ParentID=s.ID and y.OperatorID=e.ID AND u.ID=y.OperationUnitID   and  y.ParentID =#{id} ")
    List<Map<String,Object>> findBasicarchivesentryAll(Integer id);
}