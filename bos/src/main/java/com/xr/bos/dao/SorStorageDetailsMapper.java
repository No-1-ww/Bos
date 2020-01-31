package com.xr.bos.dao;

import com.xr.bos.model.SorStorageDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface SorStorageDetailsMapper {
    int addSorStorageDetails(SorStorageDetails sorStorageDetails);
}
