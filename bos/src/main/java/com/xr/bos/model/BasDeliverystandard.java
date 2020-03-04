package com.xr.bos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "bas_deliverystandard")
public class BasDeliverystandard implements Serializable {
    /**
     * 编号	自增
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 收派标准名称	唯一
     */
    @Column(name = "`Name`")
    private String name;

    /**
     * 最小重量	非负数
     */
    @Column(name = "MinWeight")
    private BigDecimal minweight;

    /**
     * 最大重量	非负数且必须大于最小重量
     */
    @Column(name = "MaxWeight")
    private BigDecimal maxweight;

    /**
     * 操作人员	外键，对应到员工表编号
     */
    @Column(name = "OperatorID")
    private Integer operatorid;

    /**
     * 操作单位	外键，对应到单位表编号
     */
    @Column(name = "OperationUnitID")
    private Integer operationunitid;

    /**
     * 操作时间	当前操作时间
     */
    @Column(name = "OperationTime")
    private Date operationtime;

    @Column(name = "InvalidateMark")
    private String invalidatemark;

    private static final long serialVersionUID = 1L;
}