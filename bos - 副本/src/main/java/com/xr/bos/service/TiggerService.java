package com.xr.bos.service;

import com.xr.bos.model.Tigger;

import java.util.List;

public interface TiggerService {
   /* void add(Tigger tigger);
*/
    void refreshTrigger();

    //查询所有任务
    List<Tigger> getTriggers();


}
