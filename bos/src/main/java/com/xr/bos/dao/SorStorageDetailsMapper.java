package com.xr.bos.dao;

import com.xr.bos.model.SorStorageDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SorStorageDetailsMapper {
    int addSorStorageDetails(SorStorageDetails sorStorageDetails);

    /**
     * 根据ID查询
     * @param SID
     * @return
     */
    List<SorStorageDetails> queryByID(Integer SID);

    Integer deleteSorStorageDetails(Integer ID);
}
