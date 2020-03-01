package com.xr.bos.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class SorOutBoundDetails {
    private Integer id;
    private String outBoundID;
    private String packageID;
    private double weight;
    private double volume;
    private double scanDate;
    private int isScan;
    private int isNextStorage;
    private int isDoubleStorage;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutBoundID() {
        return outBoundID;
    }

    public void setOutBoundID(String outBoundID) {
        this.outBoundID = outBoundID;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getScanDate() {
        return scanDate;
    }

    public void setScanDate(double scanDate) {
        this.scanDate = scanDate;
    }

    public int getIsScan() {
        return isScan;
    }

    public void setIsScan(int isScan) {
        this.isScan = isScan;
    }

    public int getIsNextStorage() {
        return isNextStorage;
    }

    public void setIsNextStorage(int isNextStorage) {
        this.isNextStorage = isNextStorage;
    }

    public int getIsDoubleStorage() {
        return isDoubleStorage;
    }

    public void setIsDoubleStorage(int isDoubleStorage) {
        this.isDoubleStorage = isDoubleStorage;
    }

    public SorOutBoundDetails() {

    }

    public SorOutBoundDetails(Integer id, String outBoundID, String packageID, double weight, double volume, double scanDate, int isScan, int isNextStorage, int isDoubleStorage) {
        this.id = id;
        this.outBoundID = outBoundID;
        this.packageID = packageID;
        this.weight = weight;
        this.volume = volume;
        this.scanDate = scanDate;
        this.isScan = isScan;
        this.isNextStorage = isNextStorage;
        this.isDoubleStorage = isDoubleStorage;
    }

    @Override
    public String toString() {
        return "SorOutBoundDetails{" +
                "id=" + id +
                ", outBoundID='" + outBoundID + '\'' +
                ", packageID='" + packageID + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", scanDate=" + scanDate +
                ", isScan=" + isScan +
                ", isNextStorage=" + isNextStorage +
                ", isDoubleStorage=" + isDoubleStorage +
                '}';
    }
}
