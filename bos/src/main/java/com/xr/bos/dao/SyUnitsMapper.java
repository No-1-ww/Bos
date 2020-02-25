package com.xr.bos.dao;

import com.xr.bos.model.SyUnits;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SyUnitsMapper {

    /**
     * 根据ID来查询
     * @param ID
     * @return
     */
     SyUnits findID(Integer ID);


    //查询所有
    List<Map<String,Object>> findUntisAll();
    //根据单位名称查询单位资料
    List<Map<String,Object>> findUntiswhereAsname(String name);

    /**
     * 添加单位
     * @param syUnits
     * @return
     */
    int addUnits(SyUnits syUnits);

    /**
     * 编辑的查询
     * @param syUnits
     * @return
     */
    List<Map<String,Object>> findUntisUpdateByID(SyUnits syUnits);


    /**
     * 修改单位信息
     * @param syUnits
     * @return
     */
    int updateSyUntisByID(SyUnits syUnits);

    /**
     * 删除单位
     * @param ID
     * @return
     */
    int delSyUntisByID(Integer ID);
}
