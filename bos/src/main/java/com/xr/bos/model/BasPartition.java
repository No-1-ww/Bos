package com.xr.bos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "bas_partition")
public class BasPartition {
    /**
     * 编号	自增
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 省
     */
    @Column(name = "Province")
    private String province;

    /**
     * 城市
     */
    @Column(name = "City")
    private String city;

    /**
     * 区（县）
     */
    @Column(name = "County")
    private String county;

    /**
     * 定区编码
     */
    @Column(name = "ZoneCode")
    private String zonecode;

    /**
     * 关键字
     */
    @Column(name = "Keyword")
    private String keyword;

    /**
     * 起始号
     */
    @Column(name = "StartInt")
    private Integer startint;

    /**
     * 终止号
     */
    @Column(name = "TerminateInt")
    private Integer terminateint;

    /**
     * 单双号	1：单，2：双
     */
    @Column(name = "SDInt")
    private Boolean sdint;

    @Column(name = "OperatorID")
    private Integer operatorid;

    @Column(name = "OperationUnitID")
    private Integer operationunitid;

    @Column(name = "AccworkorderID")
    private Integer accworkorderid;

    @Column(name = "OperationTime")
    private Date operationtime;

    @Column(name = "Stats")
    private Boolean stats;
}