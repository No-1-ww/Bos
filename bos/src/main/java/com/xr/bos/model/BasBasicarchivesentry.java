package com.xr.bos.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "bas_basicarchivesentry")
public class    BasBasicarchivesentry implements Serializable {
    /**
     * OperationTime
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 档案名称	唯一
     */
    @Column(name = "`Name`")
    private String name;

    /**
     * 上级编码	本表ID
     */
    @Column(name = "ParentID")
    private Integer parentid;

    /**
     * 助记码	唯一且只可为英文
     */
    @Column(name = "MnemonicCode")
    private String mnemoniccode;

    /**
     * 是否封存	1：是，0：否
     */
    @Column(name = "Available")
    private Boolean available;

    /**
     * 备注
     */
    @Column(name = "Remarks")
    private String remarks;

    /**
     * 操作人员	外键，对应到用户表编号
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

    @Column(name = "Stats")
    private Boolean stats;

    private static final long serialVersionUID = 1L;
}