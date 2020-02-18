package com.xr.bos.model;

import lombok.Data;

import java.util.Date;

@Data
public class BasBasicarchives {
    /**
    * 编号	自增
    */
    private Integer id;

    private String basicfilenumber;

    /**
    * 基本档案名称
    */
    private String name;

    /**
    * 档案是否分级	1：是，0：否
    */
    private Boolean grade;

    /**
    * 操作人员	外键，对应到用户表编号
    */
    private Integer operatorid;

    /**
    * 操作单位	外键，对应到单位表编号
    */
    private Integer operationunitid;

    /**
    * 备注
    */
    private String remarks;

    /**
    * 操作时间	当前操作时间
    */
    private Date operationtime;
}