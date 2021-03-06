package com.xr.bos.model;

import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class SyUnits {
    private Integer ID;
    private String name;
    private String reMarks;
    private Integer operAtorID;
    private Date operationTime;

    public SyUnits() {

    }

    public SyUnits(Integer ID, String name, String reMarks, Integer operAtorID, Date operationTime) {
        this.ID = ID;
        this.name = name;
        this.reMarks = reMarks;
        this.operAtorID = operAtorID;
        this.operationTime = operationTime;
    }

    @Override
    public String toString() {
        return "SyUnits{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", reMarks='" + reMarks + '\'' +
                ", operAtorID='" + operAtorID + '\'' +
                ", operationTime=" + operationTime +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReMarks() {
        return reMarks;
    }

    public void setReMarks(String reMarks) {
        this.reMarks = reMarks;
    }

    public Integer getOperAtorID() {
        return operAtorID;
    }

    public void setOperAtorID(Integer operAtorID) {
        this.operAtorID = operAtorID;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}
