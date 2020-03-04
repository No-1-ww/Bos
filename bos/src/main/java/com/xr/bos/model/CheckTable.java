package com.xr.bos.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class CheckTable implements Serializable {
    private Integer id;
    private String jobNo;
    private Integer jobType;
    private Integer pickupStatus;
    private String shortMessageInt;
    private Data workGenerationTime;
    private Integer afterSingleNum;
    private Integer smallMemberNum;
    private Integer pickupUnit;
    private String businessNoticeNo;
    private Data pickupTime;
    private String sortingCode;

    public CheckTable() {
    }


    public CheckTable(Integer id, String jobNo, Integer jobType, Integer pickupStatus, String shortMessageInt, Data workGenerationTime, Integer afterSingleNum, Integer smallMemberNum, Integer pickupUnit, String businessNoticeNo, Data pickupTime, String sortingCode) {
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
