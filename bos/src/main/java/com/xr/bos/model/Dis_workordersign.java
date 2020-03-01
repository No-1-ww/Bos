package com.xr.bos.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

/**
 * 工作单签收表
 */
@Data
@Component
public class Dis_workordersign implements Serializable {
    private Integer id;
    private Integer workOrderID;
    private String workSheetNo;
    private Integer workOrderType;
    private Integer signType;
    private String courierInt;
    private String courierName;
    private String recipient;
    private String signUnit;
    private Date signTime;
    private Integer invalidateMark;
    private String abnormalMark;
    private String inputPersonCode;
    private Integer inputPersonID;
    private Integer inputID;
    private Date inputTime;

    public Dis_workordersign() {
    }

    public Dis_workordersign(Integer id, Integer workOrderID, String workSheetNo, Integer workOrderType, Integer signType, String courierInt, String courierName, String recipient, String signUnit, Date signTime, Integer invalidateMark, String abnormalMark, String inputPersonCode, Integer inputPersonID, Integer inputID, Date inputTime) {
        this.id = id;
        this.workOrderID = workOrderID;
        this.workSheetNo = workSheetNo;
        this.workOrderType = workOrderType;
        this.signType = signType;
        this.courierInt = courierInt;
        this.courierName = courierName;
        this.recipient = recipient;
        this.signUnit = signUnit;
        this.signTime = signTime;
        this.invalidateMark = invalidateMark;
        this.abnormalMark = abnormalMark;
        this.inputPersonCode = inputPersonCode;
        this.inputPersonID = inputPersonID;
        this.inputID = inputID;
        this.inputTime = inputTime;
    }

    @Override
    public String toString() {
        return "Dis_workordersign{" +
                "id=" + id +
                ", workOrderID=" + workOrderID +
                ", workSheetNo='" + workSheetNo + '\'' +
                ", workOrderType=" + workOrderType +
                ", signType=" + signType +
                ", courierInt='" + courierInt + '\'' +
                ", courierName='" + courierName + '\'' +
                ", recipient='" + recipient + '\'' +
                ", signUnit='" + signUnit + '\'' +
                ", signTime=" + signTime +
                ", invalidateMark=" + invalidateMark +
                ", abnormalMark='" + abnormalMark + '\'' +
                ", inputPersonCode='" + inputPersonCode + '\'' +
                ", inputPersonID=" + inputPersonID +
                ", inputID=" + inputID +
                ", inputTime=" + inputTime +
                '}';
    }
}
