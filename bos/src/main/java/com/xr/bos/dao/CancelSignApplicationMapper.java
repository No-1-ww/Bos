package com.xr.bos.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 取消签收申请页面
 * 表是Tet_returnlike
 */
@Repository
public interface CancelSignApplicationMapper {
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
