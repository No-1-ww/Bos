package com.xr.bos.model;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class SorCheckBound {
    private String ID;
    private Integer scanID;
    private Integer cargoSum;
    private Integer checkPerson;
    private Date checkDate;
    private String checkCompany;

    public SorCheckBound() {
    }

    public SorCheckBound(String ID, Integer scanID, Integer cargoSum, Integer checkPerson, Date checkDate, String checkCompany) {
        this.ID = ID;
        this.scanID = scanID;
        this.cargoSum = cargoSum;
        this.checkPerson = checkPerson;
        this.checkDate = checkDate;
        this.checkCompany = checkCompany;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getScanID() {
        return scanID;
    }

    public void setScanID(Integer scanID) {
        this.scanID = scanID;
    }

    public Integer getCargoSum() {
        return cargoSum;
    }

    public void setCargoSum(Integer cargoSum) {
        this.cargoSum = cargoSum;
    }

    public Integer getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(Integer checkPerson) {
        this.checkPerson = checkPerson;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckCompany() {
        return checkCompany;
    }

    public void setCheckCompany(String checkCompany) {
        this.checkCompany = checkCompany;
    }
}
