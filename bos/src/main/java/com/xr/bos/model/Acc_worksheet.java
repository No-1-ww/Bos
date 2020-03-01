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
}
