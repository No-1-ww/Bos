package com.xr.bos.dao;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@ResponseBody
public interface SorCheckBoundMapper {

    List<Map<String,Object>> queryAllSorCheckBound(Map<String,Integer> map);

    Integer querySorCheckBoundCount();

}
