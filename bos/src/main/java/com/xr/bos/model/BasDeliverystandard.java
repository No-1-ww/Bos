package com.xr.bos.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BasDeliverystandard {
    /**
    * 编号	自增
    */
    private Integer id;

    /**
    * 收派标准名称	唯一
    */
    private String name;

    /**
    * 最小重量	非负数
    */
    private BigDecimal minweight;

    /**
    * 最大重量	非负数且必须大于最小重量
    */
    private BigDecimal maxweight;

    /**
    * 操作人员	外键，对应到员工表编号
    */
    private Integer operatorid;

    /**
    * 操作单位	外键，对应到单位表编号
    */
    private Integer operationunitid;

    /**
    * 操作时间	当前操作时间
    */
    private Date operationtime;
}