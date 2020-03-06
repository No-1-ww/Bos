package com.xr.bos.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 取消签收申请页面
 * 表是Tet_returnlike
 */
@Repository
public interface CancelSignApplicationMapper {
    //查询
    List<Map<String,Object>> queryall();

}
