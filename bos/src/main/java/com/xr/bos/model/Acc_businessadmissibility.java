package com.xr.bos.model;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

@Data
@Component
public class Acc_businessadmissibility implements Serializable {

    private static final long serialVersionUID = 6293628656547549756L;

    private String businessNoticeNo; //业务通知单号
    private Date reservationTime; //预约收件时间
    private String customName; //客户名称
    private String pickupAddress; //取件地址
    private String customCode; //客户编号
    private String linkman; //联系人
    private String telPhone; //电话
    private String weight; //重量
    private Double volume; //体积
    private String importantHints; //重要提示----改成产品
    private String arriveCity; //到达城市
    private Integer pickerInfo; //取货人员信息
    private String sendAddress; //派送地址
    private Integer processingUnit;  //处理单位
    private Integer notificationSource; //通知单来源
    private String customNoModifyFlag; //客户单号修改标志
    private String singleType; //分单类型
    private Integer packagesNum; //件数
    private Double actualWeight; //实际重量
    private Double billingWeight; //计费重量
    private Double packingFee; //包装费
    private Integer actualPacking; //实际包装

    public Acc_businessadmissibility() {
    }

    @Override
    public String toString() {
        return "Acc_businessadmissibility{" +
                "businessNoticeNo='" + businessNoticeNo + '\'' +
                ", reservationTime=" + reservationTime +
                ", customName='" + customName + '\'' +
                ", pickupAddress='" + pickupAddress + '\'' +
                ", customCode='" + customCode + '\'' +
                ", linkman='" + linkman + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", weight='" + weight + '\'' +
                ", volume=" + volume +
                ", importantHints='" + importantHints + '\'' +
                ", arriveCity='" + arriveCity + '\'' +
                ", pickerInfo=" + pickerInfo +
                ", sendAddress='" + sendAddress + '\'' +
                ", processingUnit=" + processingUnit +
                ", notificationSource=" + notificationSource +
                ", customNoModifyFlag='" + customNoModifyFlag + '\'' +
                ", singleType='" + singleType + '\'' +
                ", packagesNum=" + packagesNum +
                ", actualWeight=" + actualWeight +
                ", billingWeight=" + billingWeight +
                ", packingFee=" + packingFee +
                ", actualPacking=" + actualPacking +
                '}';
    }

    public Acc_businessadmissibility(String businessNoticeNo, Date reservationTime, String customName, String pickupAddress, String customCode, String linkman, String telPhone, String weight, Double volume, String importantHints, String arriveCity, Integer pickerInfo, String sendAddress, Integer processingUnit, Integer notificationSource, String customNoModifyFlag, String singleType, Integer packagesNum, Double actualWeight, Double billingWeight, Double packingFee, Integer actualPacking) {
        this.businessNoticeNo = businessNoticeNo;
        this.reservationTime = reservationTime;
        this.customName = customName;
        this.pickupAddress = pickupAddress;
        this.customCode = customCode;
        this.linkman = linkman;
        this.telPhone = telPhone;
        this.weight = weight;
        this.volume = volume;
        this.importantHints = importantHints;
        this.arriveCity = arriveCity;
        this.pickerInfo = pickerInfo;
        this.sendAddress = sendAddress;
        this.processingUnit = processingUnit;
        this.notificationSource = notificationSource;
        this.customNoModifyFlag = customNoModifyFlag;
        this.singleType = singleType;
        this.packagesNum = packagesNum;
        this.actualWeight = actualWeight;
        this.billingWeight = billingWeight;
        this.packingFee = packingFee;
        this.actualPacking = actualPacking;
    }
}
