package com.xr.bos.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CancelSignApplicationService {
    /**
     * 查询
     * @return
     */
    List<Map<String,Object>> queryall();

    /**
     * 根据id查询
     * @param workSheetNo
     * @return
     */
    @Select("select r.id,r.workSheetNo,r.applicationNo,d.signTime,d.signType,d.signUnit,e.empName,d.inputTime,u.`Name`,r.personName" +
            "from dis_workordersign d,ret_returnlist r,sy_units u,sy_emp e" +
            "where d.inputPersonID=e.id and d.inputID=u.id and r.workSheetNo=#{workSheetNo}")
    Map<String,Object> queryByID(String workSheetNo);
}
