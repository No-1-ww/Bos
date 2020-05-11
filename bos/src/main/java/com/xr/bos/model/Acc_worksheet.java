package com.xr.bos.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class Acc_worksheet implements Serializable {

    private static final long serialVersionUID = 2398610029825169081L;

    private Integer id; //编号
    private String workSheetNo; //工作单号
    private String destination; //到达地
    private String productTime; //产品时限
    private Integer total; //总件数
    private Double weight; //重量
    private String stowageRequirements; //配载要求



    public Acc_worksheet(Integer id, String workSheetNo, String destination, String productTime, Integer total, Double weight, String stowageRequirements) {
        this.id = id;
        this.workSheetNo = workSheetNo;
        this.destination = destination;
        this.productTime = productTime;
        this.total = total;
        this.weight = weight;
        this.stowageRequirements = stowageRequirements;
    }

    public Acc_worksheet() {
    }

    @Override
    public String toString() {
        return "Acc_worksheet{" +
                "id=" + id +
                ", workSheetNo='" + workSheetNo + '\'' +
                ", destination='" + destination + '\'' +
                ", productTime='" + productTime + '\'' +
                ", total=" + total +
                ", weight=" + weight +
                ", stowageRequirements='" + stowageRequirements + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkSheetNo() {
        return workSheetNo;
    }

    public void setWorkSheetNo(String workSheetNo) {
        this.workSheetNo = workSheetNo;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getProductTime() {
        return productTime;
    }

    public void setProductTime(String productTime) {
        this.productTime = productTime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getStowageRequirements() {
        return stowageRequirements;
    }

    public void setStowageRequirements(String stowageRequirements) {
        this.stowageRequirements = stowageRequirements;
    }
}
