package com.xr.bos.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SorOutBoundMapper {

    //pageHelper失效暂时先用map集合page,limit代替
    List<Map<String,Object>> queryAll(Map<String,Integer> map);
}
