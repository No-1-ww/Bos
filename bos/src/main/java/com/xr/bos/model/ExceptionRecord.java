package com.xr.bos.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

@Component
public class ExceptionRecord implements Serializable {
    private Integer id;
    private Date launchDate;
    private String launchPerson;
    private String launchCompany;
    private Integer abnormalType;
    private String TransferInt;
    private String cargoInt;
    private String packageInt;
    private int hedgeAbnInt;
    private int aboState;
    private Date handleDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public String getLaunchPerson() {
        return launchPerson;
    }

    public void setLaunchPerson(String launchPerson) {
        this.launchPerson = launchPerson;
    }

    public String getLaunchCompany() {
        return launchCompany;
    }

    public void setLaunchCompany(String launchCompany) {
        this.launchCompany = launchCompany;
    }

    public Integer getAbnormalType() {
        return abnormalType;
    }

    public void setAbnormalType(Integer abnormalType) {
        this.abnormalType = abnormalType;
    }

    public String getTransferInt() {
        return TransferInt;
    }

    public void setTransferInt(String transferInt) {
        TransferInt = transferInt;
    }

    public String getCargoInt() {
        return cargoInt;
    }

    public void setCargoInt(String cargoInt) {
        this.cargoInt = cargoInt;
    }

    public String getPackageInt() {
        return packageInt;
    }

    public void setPackageInt(String packageInt) {
        this.packageInt = packageInt;
    }

    public int getHedgeAbnInt() {
        return hedgeAbnInt;
    }

    public void setHedgeAbnInt(int hedgeAbnInt) {
        this.hedgeAbnInt = hedgeAbnInt;
    }

    public int getAboState() {
        return aboState;
    }

    public void setAboState(int aboState) {
        this.aboState = aboState;
    }

    public Date getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(Date handleDate) {
        this.handleDate = handleDate;
    }

    public ExceptionRecord() {

    }

    public ExceptionRecord(Integer id, Date launchDate, String launchPerson, String launchCompany, Integer abnormalType, String transferInt, String cargoInt, String packageInt, int hedgeAbnInt, int aboState, Date handleDate) {
        this.id = id;
        this.launchDate = launchDate;
        this.launchPerson = launchPerson;
        this.launchCompany = launchCompany;
        this.abnormalType = abnormalType;
        TransferInt = transferInt;
        this.cargoInt = cargoInt;
        this.packageInt = packageInt;
        this.hedgeAbnInt = hedgeAbnInt;
        this.aboState = aboState;
        this.handleDate = handleDate;
    }

    @Override
    public String toString() {
        return "ExceptionRecord{" +
                "id=" + id +
                ", launchDate=" + launchDate +
                ", launchPerson='" + launchPerson + '\'' +
                ", launchCompany='" + launchCompany + '\'' +
                ", abnormalType=" + abnormalType +
                ", TransferInt='" + TransferInt + '\'' +
                ", cargoInt='" + cargoInt + '\'' +
                ", packageInt='" + packageInt + '\'' +
                ", hedgeAbnInt=" + hedgeAbnInt +
                ", aboState=" + aboState +
                ", handleDate=" + handleDate +
                '}';
    }
}
