package com.xr.bos.service.impl;

import com.xr.bos.dao.BasStandartimeMapper;
import com.xr.bos.model.BasStandartime;
import com.xr.bos.model.SyUnits;
import com.xr.bos.service.BasStandartimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BasStandartimeServiceImpl implements BasStandartimeService {

    @Resource
    private BasStandartimeMapper basStandartimeMapper;

    @Override
    public List<Map<String, Object>> findstandartimeAll() {
        return basStandartimeMapper.findstandartimeAll();
    }

    /**
     * 下拉框查询单位
     * @return
     */
    @Override
    public List<SyUnits> selectedFindUnitsName() {
        return basStandartimeMapper.selectedFindUnitsName();
    }

    /**
     * 多条件查询
     * @param standartime
     * @return
     */
    @Override
    public List<Map<String, Object>> findstandartimeByTimeNameAndSubordinateUnit(BasStandartime standartime) {
        return basStandartimeMapper.findstandartimeByTimeNameAndSubordinateUnit(standartime);
    }

    /**
     * 添加收派时间管理
     * @param basStandartime
     * @return
     */
    @Override
    public int addBastandartime(BasStandartime basStandartime) {
        return basStandartimeMapper.addBastandartime(basStandartime);
    }
    /**
     * 修改赋值 ，根据id查询
     * @param standartime
     * @return
     */
    @Override
    public List<Map<String, Object>> finddeliverytimeByID(BasStandartime standartime) {
        return basStandartimeMapper.finddeliverytimeByID(standartime);
    }


    /**
     * 修改收派时间
     * @param standartime
     * @return
     */
    @Override
    public int updateBasStandartime(BasStandartime standartime) {
        return basStandartimeMapper.updateBasStandartime(standartime);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteBasStandartime(Integer id) {
        return basStandartimeMapper.deleteBasStandartime(id);
    }
}
