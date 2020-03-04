package com.xr.bos.service.impl;

import com.xr.bos.dao.BasDeliverystandardMapper;
import com.xr.bos.model.BasDeliverystandard;
import com.xr.bos.model.SyEmp;
import com.xr.bos.service.BasDeliverystandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BasDeliverystandardServiceImpl implements BasDeliverystandardService {

    @Autowired
    private BasDeliverystandardMapper deliverystandardMapper;

    @Override
    public List<Map<String, Object>> findBasDeliverystandardAll() {
        return deliverystandardMapper.findBasDeliverystandardAll();
    }

    /**
     * 根据登录的id查询登录人的单位名称
     * @param
     * @return
     */
    @Override
    public List<Map<String, Object>> findEmpNameAndUntisNameByID(Integer ID) {
        return deliverystandardMapper.findEmpNameAndUntisNameByID(ID);
    }

    /**
     * 添加收派标准
     * @param deliverystandard
     * @return
     */
    @Override
    public int addBasDeliverystandard(BasDeliverystandard deliverystandard) {
        return deliverystandardMapper.addBasDeliverystandard(deliverystandard);
    }

    /**
     * 根据id查询
     *
     * @param ID
     * @return
     */
    @Override
    public List<Map<String, Object>> findBasDeliverystanrdByID(Integer ID) {
        return deliverystandardMapper.findBasDeliverystanrdByID(ID);
    }

    /**
     * 修改
     * @param deliverystandard
     * @return
     */
    @Override
    public int updateBasDeliverstanrd(BasDeliverystandard deliverystandard) {
        return deliverystandardMapper.updateBasDeliverstanrd(deliverystandard);
    }

    /**
     * 作废
     * @param deliverystandard
     * @return
     */
    @Override
    public int deleteBasDeliverstanrd(BasDeliverystandard deliverystandard) {
        return deliverystandardMapper.deleteBasDeliverstanrd(deliverystandard);
    }

    //查询操作人
    @Override
    public List<SyEmp> findOperatorID() {
        return deliverystandardMapper.findOperatorID();
    }

    //多条件查询
    @Override
    public List<Map<String, Object>> findBasDeliverystandardByNameAndInvalidateMark(BasDeliverystandard deliverystandard) {
        return deliverystandardMapper.findBasDeliverystandardByNameAndInvalidateMark(deliverystandard);
    }
}
