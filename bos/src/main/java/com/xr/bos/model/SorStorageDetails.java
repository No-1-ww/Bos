package com.xr.bos.model;

import org.springframework.stereotype.Component;

@Component
public class SorStorageDetails {
    private Integer SID;
    private String packageID;
    private double weiGht;
    private String outBoundID;
    private int state;

    public SorStorageDetails() {

    }

    public SorStorageDetails(Integer ID, String packageID, double weiGht, String outBoundID, int state) {
        this.SID = ID;
        this.packageID = packageID;
        this.weiGht = weiGht;
        this.outBoundID = outBoundID;
        this.state = state;
    }

    public Integer getID() {
        return SID;
    }

    public void setID(Integer ID) {
        this.SID = ID;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public double getWeiGht() {
        return weiGht;
    }

    public void setWeiGht(double weiGht) {
        this.weiGht = weiGht;
    }

    public String getOutBoundID() {
        return outBoundID;
    }

    public void setOutBoundID(String outBoundID) {
        this.outBoundID = outBoundID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SorStorageDetails{" +
                "SID=" + SID +
                ", packageID='" + packageID + '\'' +
                ", weiGht=" + weiGht +
                ", outBoundID='" + outBoundID + '\'' +
                ", state=" + state +
                '}';
    }
}
