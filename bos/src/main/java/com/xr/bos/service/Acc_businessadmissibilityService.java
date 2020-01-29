package com.xr.bos.service;



import com.xr.bos.model.Acc_businessadmissibility;

import java.util.List;
import java.util.Map;

public interface Acc_businessadmissibilityService {
    List<Map<String,Object>> queryAcc_businessadmissibility();

    //新增
    int addBusin(Acc_businessadmissibility acc_businessadmissibility);
    //根据业务单的单号查询最大值
    String querybusinNo_ID();

    //产品下拉框字段查询
    List<Acc_businessadmissibility> query_importantHints();

    //根据id查询
    Acc_businessadmissibility queryByIDbusinessNoticeNo(String businessNoticeNo);

    //条件查询
    List<Acc_businessadmissibility> query_whereAcc(String businessNoticeNo,String customCode);
}
