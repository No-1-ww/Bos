package com.xr.bos.dao;

import com.xr.bos.model.SyUnits;
import org.springframework.stereotype.Repository;

@Repository
public interface SyUnitsMapper {

    /**
     * 根据ID来查询
     * @param ID
     * @return
     */
     SyUnits findID(Integer ID);
}
