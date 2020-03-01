package com.xr.bos.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Date;

@Data
@Table(name = "bas_standartime")
public class BasStandartime {
    /**
     * 编号	自增
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 时间名称	唯一
     */
    @Column(name = "TimeName")
    private String timename;

    /**
     * 所属单位	外键，对应到单位表ID
     */
    @Column(name = "SubordinateUnit")
    private Integer subordinateunit;

    /**
     * 平时上班时间	只需要时分，不需要日期
     */
   // @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "WorkingTime")
    private Time workingtime;

    /**
     * 平时下班时间	只需要时分，不需要日期
     */
    //@DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "ClosingTime")
    private Time closingtime;

    /**
     * 周六上班时间	只需要时分，不需要日期
     */
    //@DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "SaturdayWorkingTime")
    private Time saturdayworkingtime;

    /**
     * 周六下班时间	只需要时分，不需要日期
     */
  //  @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "SaturdayClosingTime")
    private Time saturdayclosingtime;

    /**
     * 周日上班时间	只需要时分，不需要日期
     */
   // @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "SundayWorkingTime")
    private Time sundayworkingtime;

    /**
     * 周日下班时间	只需要时分，不需要日期
     */
    //@DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "SundayClosingTime")
    private Time sundayclosingtime;
}