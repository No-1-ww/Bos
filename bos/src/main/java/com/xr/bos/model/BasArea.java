package com.xr.bos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "bas_area")
public class BasArea {
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
     * 邮政编码
     */
    @Column(name = "PostalCode")
    private Integer postalcode;

    /**
     * 简码
     */
    @Column(name = "SimpleCode")
    private String simplecode;

    /**
     * 城市编码
     */
    @Column(name = "CityCode")
    private Integer citycode;

    /**
     * 进港单位	外键，对应到单位表编号
     */
    @Column(name = "EntryUnitID")
    private Integer entryunitid;

    /**
     * 出港单位	外键，对应到单位表编号
     */
    @Column(name = "ComplementUnitID")
    private Integer complementunitid;

    /**
     * 性质	1.省级 2.市辖市 3.直辖市 
            4.县级5.地级 6.省会
     */
    @Column(name = "Nature")
    private Integer nature;

    /**
     * 所属区域	1.东北区2.华东区 3.华南区 
            4.西北区 5华中区 6西南区 7华北区
     */
    @Column(name = "TheArea")
    private Integer thearea;

    /**
     * 0：正常，1：停用
     */
    @Column(name = "Stats")
    private Boolean stats;

    /**
     * 操作人的id
     */
    @Column(name = "OperatorID")
    private Integer operatorid;

    /**
     * 操作员的操作单位
     */
    @Column(name = "OperationUnitID")
    private Integer operationunitid;

    /**
     * 操作时间
     */
    @Column(name = "OperationTime")
    private Date operationtime;
}