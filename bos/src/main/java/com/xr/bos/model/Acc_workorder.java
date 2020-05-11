package com.xr.bos.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

@Data
@Component
public class Acc_workorder implements Serializable {
    private Integer id;
    private String jobNo;
    private Integer jobType;
    private Integer pickupStatus;
    private String shortMessageInt;
    private Date workGenerationTime;
    private Integer afterSingleNum;
    private Integer smallMemberNum;
    private Integer pickupUnit;
    private String businessNoticeNo;
    private Date pickupTime;
    private String sortingCode;

    public Acc_workorder() {
    }

    public Acc_workorder(Integer id, String jobNo, Integer jobType, Integer pickupStatus, String shortMessageInt, Date workGenerationTime, Integer afterSingleNum, Integer smallMemberNum, Integer pickupUnit, String businessNoticeNo, Date pickupTime, String sortingCode) {
        this.id = id;
        this.jobNo = jobNo;
        this.jobType = jobType;
        this.pickupStatus = pickupStatus;
        this.shortMessageInt = shortMessageInt;
        this.workGenerationTime = workGenerationTime;
        this.afterSingleNum = afterSingleNum;
        this.smallMemberNum = smallMemberNum;
        this.pickupUnit = pickupUnit;
        this.businessNoticeNo = businessNoticeNo;
        this.pickupTime = pickupTime;
        this.sortingCode = sortingCode;
    }

    @Override
    public String toString() {
        return "Acc_workorder{" +
                "id=" + id +
                ", jobNo='" + jobNo + '\'' +
                ", jobType=" + jobType +
                ", pickupStatus=" + pickupStatus +
                ", shortMessageInt='" + shortMessageInt + '\'' +
                ", workGenerationTime=" + workGenerationTime +
                ", afterSingleNum=" + afterSingleNum +
                ", smallMemberNum=" + smallMemberNum +
                ", pickupUnit=" + pickupUnit +
                ", businessNoticeNo='" + businessNoticeNo + '\'' +
                ", pickupTime=" + pickupTime +
                ", sortingCode='" + sortingCode + '\'' +
                '}';
    }
}
