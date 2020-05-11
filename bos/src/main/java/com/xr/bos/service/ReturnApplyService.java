package com.xr.bos.service;

import com.xr.bos.model.Ret_returnlist;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ReturnApplyService {
    /**
     * 返货申请查询
     * @return
     */
    List<Map<String,Object>> queryall();

    /**
     * 新增
     * @param ret_returnlist
     * @return
     */
    int add_Apply(Ret_returnlist ret_returnlist);

    /**
     * 查询最大申请单号
     * @return
     */
    String query_ApplicationNo();

    /**
     * 查询最大工作单号
     * @return
     */
    String query_WorkSheetNo();

    /**
     * 查询员工表以及单位表--下拉框
     * @return
     */
    List<Ret_returnlist> query_empName();
    List<Ret_returnlist> query_Name();

    /**
     * 删除
     * @param applicationNo
     * @return
     */
    @Delete("DELETE from ret_returnlist where ApplicationNo=#{applicationNo}")
    int del_retu(String applicationNo);

    /**
     * 根据id查询
     * @param workSheetNo
     * @return
     */
    @Select("select r.id,r.applicationNo,r.workSheetNo,r.returnType,r.apLoss,r.entryTime,s.`Name`,invalidateSign,s.`Name`,s.`Name`,r.personName" +
            "from ret_returnlist r,sy_units s" +
            "where r.returnUnit=s.id and r.entryUnit=s.id and r.receivegUnit=s.id and r.workSheetNo=#{workSheetNo}")
    Map<String,Object> queryByid(String workSheetNo);


/**********************************************************************
     * 以下是第二个模板返货申请确认
     */
    //返货货申请确认查询
    List<Map<String,Object>> queryaConfim();














/***********************************************************************
     * 以下是第三个模板生成返货单
     */
    //生成返货确认查询
    List<Map<String,Object>> queryProduce();
}
