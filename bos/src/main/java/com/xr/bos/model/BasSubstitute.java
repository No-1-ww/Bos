package com.xr.bos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "bas_substitute")
public class BasSubstitute {
    /**
     * 编号
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 员工工号对应员工表员工工号
     */
    @Column(name = "EmpNo")
    private String empno;

    /**
     * 员工名称对应员工表员姓名
     */
    @Column(name = "EmpName")
    private String empname;

    /**
     * 手机号码
     */
    @Column(name = "MobileNo")
    private String mobileno;

    /**
     * 取派员类型	对应“基础档案表”表ID
     */
    @Column(name = "`Type`")
    private Integer type;

    /**
     * 是否使用PDA	1：使用，0：不使用
     */
    @Column(name = "PDA")
    private Boolean pda;

    /**
     * 收派标准（公斤）	保留二位小数使用，0：不使用
     */
    @Column(name = "StandardKg")
    private BigDecimal standardkg;

    /**
     * 收派标准（长度）
     */
    @Column(name = "StandardLength")
    private Long standardlength;

    /**
     * 车型
     */
    @Column(name = "Models")
    private String models;

    /**
     * 车牌号
     */
    @Column(name = "PlateInt")
    private String plateint;

    /**
     * 作废标记
     */
    @Column(name = "InvalidateMark")
    private Boolean invalidatemark;

    /**
     * 所属单位	外键，对应到单位表编号
     */
    @Column(name = "SubordinateUnit")
    private Integer subordinateunit;

    /**
     * 状态，0：正常，1：停用
     */
    @Column(name = "Stats")
    private Boolean stats;

    @Column(name = "OperationTime")
    private Date operationtime;

    /**
     * 操作人id  对应emp表
     */
    @Column(name = "OperatorID")
    private Integer operatorid;
}