package com.xr.bos.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Bigloglogisticscontroltable implements Serializable {

    private static final long serialVersionUID = 3847332459212184350L;
    private int id;
    private String workSheetNo;

    private String cType;
    private String corporation;
    private String waybillID;
    private String remarks;
    private int inputPerson;
    private  int limit;
    private  int page;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    private  String EmpName;
    private String inputDate;
    private int inputCompany;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkSheetNo() {
        return workSheetNo;
    }

    public void setWorkSheetNo(String workSheetNo) {
        this.workSheetNo = workSheetNo;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getWaybillID() {
        return waybillID;
    }

    public void setWaybillID(String waybillID) {
        this.waybillID = waybillID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getInputPerson() {
        return inputPerson;
    }

    public void setInputPerson(int inputPerson) {
        this.inputPerson = inputPerson;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public int getInputCompany() {
        return inputCompany;
    }

    public void setInputCompany(int inputCompany) {
        this.inputCompany = inputCompany;
    }
}
