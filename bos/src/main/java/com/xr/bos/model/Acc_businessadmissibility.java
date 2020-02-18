package com.xr.bos.model;


import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBusinessNoticeNo() {
        return businessNoticeNo;
    }

    public void setBusinessNoticeNo(String businessNoticeNo) {
        this.businessNoticeNo = businessNoticeNo;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getCustomCode() {
        return customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getImportantHints() {
        return importantHints;
    }

    public void setImportantHints(String importantHints) {
        this.importantHints = importantHints;
    }

    public String getArriveCity() {
        return arriveCity;
    }

    public void setArriveCity(String arriveCity) {
        this.arriveCity = arriveCity;
    }

    public Integer getPickerInfo() {
        return pickerInfo;
    }

    public void setPickerInfo(Integer pickerInfo) {
        this.pickerInfo = pickerInfo;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public Integer getProcessingUnit() {
        return processingUnit;
    }

    public void setProcessingUnit(Integer processingUnit) {
        this.processingUnit = processingUnit;
    }

    public Integer getNotificationSource() {
        return notificationSource;
    }

    public void setNotificationSource(Integer notificationSource) {
        this.notificationSource = notificationSource;
    }

    public String getCustomNoModifyFlag() {
        return customNoModifyFlag;
    }

    public void setCustomNoModifyFlag(String customNoModifyFlag) {
        this.customNoModifyFlag = customNoModifyFlag;
    }

    public String getSingleType() {
        return singleType;
    }

    public void setSingleType(String singleType) {
        this.singleType = singleType;
    }

    public Integer getPackagesNum() {
        return packagesNum;
    }

    public void setPackagesNum(Integer packagesNum) {
        this.packagesNum = packagesNum;
    }

    public Double getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(Double actualWeight) {
        this.actualWeight = actualWeight;
    }

    public Double getBillingWeight() {
        return billingWeight;
    }

    public void setBillingWeight(Double billingWeight) {
        this.billingWeight = billingWeight;
    }

    public Double getPackingFee() {
        return packingFee;
    }

    public void setPackingFee(Double packingFee) {
        this.packingFee = packingFee;
    }

    public Integer getActualPacking() {
        return actualPacking;
    }

    public void setActualPacking(Integer actualPacking) {
        this.actualPacking = actualPacking;
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
