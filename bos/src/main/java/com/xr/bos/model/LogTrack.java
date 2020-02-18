package com.xr.bos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "log_track")
public class LogTrack {
    /**
     * 跟踪表编号
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 线路类型
     */
    @Column(name = "LineType")
    private String linetype;

    /**
     * 线路名称
     */
    @Column(name = "LineName")
    private String linename;

    /**
     * 线路名称
     */
    @Column(name = "LogisticsCar")
    private String logisticscar;

    /**
     * 状态
     */
    @Column(name = "LineState")
    private Boolean linestate;

    /**
     * 节点名称
     */
    @Column(name = "`NodeName`")
    private String nodename;

    /**
     * 发车时间
     */
    @Column(name = "StartTime")
    private Date starttime;

    /**
     * 到达时间
     */
    @Column(name = "ArrivalTime")
    private Date arrivaltime;

    /**
     * 车号
     */
    @Column(name = "CarInt")
    private String carint;

    /**
     * 下一节点可装载量
     */
    @Column(name = "NextNodeLoad")
    private String nextnodeload;

    /**
     * 描述
     */
    @Column(name = "Describes")
    private String describes;
}