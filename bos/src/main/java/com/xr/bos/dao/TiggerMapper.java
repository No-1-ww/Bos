package com.xr.bos.dao;

import com.xr.bos.model.Tigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface TiggerMapper {
    //添加任务
    /*void add(Tigger tigger);*/
    //查询所有任务
    List<Tigger> getTriggers();

}
