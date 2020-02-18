package com.xr.bos.service.impl;

import com.xr.bos.dao.Bigloglogisticscontroltabledao;
import com.xr.bos.model.Bigloglogisticscontroltable;
import com.xr.bos.service.Bigloglogisticscontroltableservice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("Bigloglogisticscontroltableservice")
public class Bigloglogisticscontroltableserviceimpl implements Bigloglogisticscontroltableservice {
    @Resource
    private Bigloglogisticscontroltabledao btd;

    @Override
    public List<Bigloglogisticscontroltable> select(int page,int limit) {
        page = page-1+5;
        return btd.select(page,limit);
    }

    @Override
    public List<Bigloglogisticscontroltable> selectwhere(String WorkSheetNo, String Corporation) {
        return btd.selectwhere(WorkSheetNo,Corporation);
    }

    @Override
    public Map<String,Object> selectmax() {
        return btd.selectmax();
    }

    @Override
    public int insertBL(Bigloglogisticscontroltable blt) {
        return btd.insertBL(blt);
    }
}
