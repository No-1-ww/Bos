package com.xr.bos.service;

import com.xr.bos.model.BasBasicarchivesentry;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BasBasicarchivesentryService{

    /**
     * 查询详情信息
     * @param id
     * @return
     */
   List<Map<String,Object>> findBasicarchivesentryAll(Integer id);

    /**
     * 根据登录的id查询登录人的单位名称
     *
     * @param
     * @return
     */
    List<Map<String, Object>> findEmpNameAndUntisNameByID(Integer ID);

    /**
     * 添加条目信息
     * @param basicarchivesentry
     * @return
     */
    int addBasicarchivesentry(BasBasicarchivesentry basicarchivesentry);
}
