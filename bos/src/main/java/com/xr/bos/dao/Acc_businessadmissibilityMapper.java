package com.xr.bos.dao;

import com.xr.bos.model.Acc_businessadmissibility;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 业务受理表
 */

@Repository
public interface Acc_businessadmissibilityMapper {
    //查询
    List<Map<String,Object>> queryall();

    //总数
    //Integer totalAcc_admin();

    //新增
    int addBusin(Acc_businessadmissibility acc_businessadmissibility);
    //根据业务单的通知单号查询最大值
    String querybusinNo_ID();
    //根据业务单的客户单号的最大值
    String query_customCode();


    //产品下拉框字段查询
    List<Acc_businessadmissibility> query_importantHints();

    //根据id查询
    Acc_businessadmissibility queryByIDbusinessNoticeNo(String businessNoticeNo);

    //修改
    int updateAcc(Acc_businessadmissibility acc_businessadmissibility);

    //条件查询
    List<Acc_businessadmissibility> query_whereAcc(Acc_businessadmissibility acc_businessadmissibility);

    //追单
    int update_afterSingleNum(String businessNoticeNo);
}
