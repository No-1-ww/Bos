package com.xr.bos.service;

import com.xr.bos.model.BasDeliverystandard;
import com.xr.bos.model.SyEmp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface BasDeliverystandardService{

    //查询所有收派标准
    List<Map<String,Object>> findBasDeliverystandardAll();

    /**
     * 根据登录的id查询登录人的单位名称
     * @param
     * @return
     */
    List<Map<String,Object>> findEmpNameAndUntisNameByID(Integer ID);

    /**
     * 添加收派标准
     * @param deliverystandard
     * @return
     */
    int addBasDeliverystandard(BasDeliverystandard deliverystandard);


    /**
     * 根据id查询
     *
     * @param ID
     * @return
     */
    List<Map<String, Object>> findBasDeliverystanrdByID(@Param("ID") Integer ID);

    /**
     * 修改
     * @param deliverystandard
     * @return
     */
   int updateBasDeliverstanrd(BasDeliverystandard deliverystandard);

    /**
     * 作废
     * @param deliverystandard
     * @return
     */
   int  deleteBasDeliverstanrd(BasDeliverystandard deliverystandard);

    //查询操作人
    List<SyEmp> findOperatorID();

    //多条件查询
    List<Map<String, Object>> findBasDeliverystandardByNameAndInvalidateMark(BasDeliverystandard deliverystandard);

}
