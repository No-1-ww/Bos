package com.xr.bos.dao;

import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CheckTableMapper {

    //查询所有
    List<Map<String,Object>> queryall();
}
