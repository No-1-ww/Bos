package com.xr.bos.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public Integer getPickupStatus() {
        return pickupStatus;
    }

    public void setPickupStatus(Integer pickupStatus) {
        this.pickupStatus = pickupStatus;
    }

    public String getShortMessageInt() {
        return shortMessageInt;
    }

    public void setShortMessageInt(String shortMessageInt) {
        this.shortMessageInt = shortMessageInt;
    }

    public Date getWorkGenerationTime() {
        return workGenerationTime;
    }

    public void setWorkGenerationTime(Date workGenerationTime) {
        this.workGenerationTime = workGenerationTime;
    }

    public Integer getAfterSingleNum() {
        return afterSingleNum;
    }

    public void setAfterSingleNum(Integer afterSingleNum) {
        this.afterSingleNum = afterSingleNum;
    }

    public Integer getSmallMemberNum() {
        return smallMemberNum;
    }

    public void setSmallMemberNum(Integer smallMemberNum) {
        this.smallMemberNum = smallMemberNum;
    }

    public Integer getPickupUnit() {
        return pickupUnit;
    }

    public void setPickupUnit(Integer pickupUnit) {
        this.pickupUnit = pickupUnit;
    }

    public String getBusinessNoticeNo() {
        return businessNoticeNo;
    }

    public void setBusinessNoticeNo(String businessNoticeNo) {
        this.businessNoticeNo = businessNoticeNo;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getSortingCode() {
        return sortingCode;
    }

    public void setSortingCode(String sortingCode) {
        this.sortingCode = sortingCode;
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
