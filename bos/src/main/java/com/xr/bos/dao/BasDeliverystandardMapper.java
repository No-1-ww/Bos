package com.xr.bos.dao;

import com.xr.bos.model.BasDeliverystandard;
import com.xr.bos.model.SyEmp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BasDeliverystandardMapper extends Mapper<BasDeliverystandard> {

    //查询所有收派标准
    List<Map<String, Object>> findBasDeliverystandardAll();

    /**
     * 根据登录的id查询登录人的单位名称
     *
     * @param
     * @return
     */
    @Select("SELECT e.EmpName,u.`Name` as Uname FROM sy_emp e,sy_units u where 1=1 and u.ID=e.EmpUnit and e.ID=#{ID} ")
    List<Map<String, Object>> findEmpNameAndUntisNameByID(Integer ID);

    /**
     * 添加收派标准
     *
     * @param deliverystandard
     * @return
     */
    @Insert("INSERT INTO `bos`.`bas_deliverystandard`( `Name`, `MinWeight`, `MaxWeight`, `OperatorID`, `OperationUnitID`, `OperationTime`, `InvalidateMark`) VALUES ( #{name} , #{minweight} , #{maxweight} , #{operatorid} ,#{operationunitid} ,#{operationtime} ,${invalidatemark} )")
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
    @Update("UPDATE `bos`.`bas_deliverystandard` SET `Name` =#{name} , `MinWeight` =#{minweight} , `MaxWeight` =#{maxweight} , `OperationTime` = #{operationtime} , `InvalidateMark` = ${invalidatemark} WHERE `ID` = #{id}")
    int updateBasDeliverstanrd(BasDeliverystandard deliverystandard);

    /**
     * 作废
     * @param deliverystandard
     * @return
     */
    @Update("UPDATE `bos`.`bas_deliverystandard` SET  `InvalidateMark` = false  WHERE `ID` = #{id}")
    int  deleteBasDeliverstanrd(BasDeliverystandard deliverystandard);

    //多条件查询
    List<Map<String, Object>> findBasDeliverystandardByNameAndInvalidateMark(BasDeliverystandard deliverystandard);

    //查询操作人
    @Select("select ID,EmpName from sy_emp")
    List<SyEmp> findOperatorID();

}