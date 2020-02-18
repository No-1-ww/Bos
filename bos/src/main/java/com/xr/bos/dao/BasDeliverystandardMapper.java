package com.xr.bos.dao;

import java.util.List;
import java.util.Map;

public interface BasDeliverystandardMapper {
    //查询所有收派标准
    List<Map<String,Object>> findBasDeliverystandardAll();
}