package com.xr.bos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "bas_zoneinfo")
public class BasZoneinfo implements Serializable {

    private static final long serialVersionUID = 4738740486390292709L;
    /**
     * 定区名称
     */
    @Id
    @Column(name = "ZoneName")
    private String zonename;

    /**
     * 定区编码	唯一
     */
    @Column(name = "ZoneCode")
    private String zonecode;

    /**
     * 定区负责人	外键，对应到员工表ID
     */
    @Column(name = "ZonePeople")
    private Integer zonepeople;

    /**
     * 联系电话
     */
    @Column(name = "TelPhone")
    private String telphone;

    /**
     * 所属单位	外键，对应到单位表ID
     */
    @Column(name = "SubordinateUnit")
    private Integer subordinateunit;

    @Column(name = "Stats")
    private Boolean stats;
}