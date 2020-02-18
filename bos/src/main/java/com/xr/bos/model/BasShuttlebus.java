package com.xr.bos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "bas_shuttlebus")
public class BasShuttlebus {
    /**
     * 编号	自增
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 线路类型	1．全部 2．干线 3．周边 
            4．省内 5．临时 6．市内
     */
    @Column(name = "LineType")
    private Boolean linetype;

    /**
     * 线路	外键，线路ID
     */
    @Column(name = "LineID")
    private Integer lineid;

    /**
     * 车牌号
     */
    @Column(name = "LicensePlateInt")
    private String licenseplateint;

    /**
     * 承运商
     */
    @Column(name = "Carrier")
    private String carrier;

    /**
     * 车型
     */
    @Column(name = "Models")
    private String models;

    /**
     * 司机
     */
    @Column(name = "Driver")
    private String driver;

    /**
     * 电话
     */
    @Column(name = "Telephone")
    private String telephone;

    /**
     * 吨控
     */
    @Column(name = "Ton")
    private Integer ton;

    /**
     * 备注
     */
    @Column(name = "Remarks")
    private String remarks;

    /**
     * 操作单位	外键，对应到单位表编号
     */
    @Column(name = "OperationUnitID")
    private Integer operationunitid;

    /**
     * 操作单位	外键，对应到单位表编号
     */
    @Column(name = "OperatorID")
    private Integer operatorid;

    /**
     * 操作时间	当前操作时间
     */
    @Column(name = "OperationTime")
    private String operationtime;
}