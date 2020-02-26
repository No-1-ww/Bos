package com.xr.bos.model;

import java.sql.Date;

public class SorOutBound {
    private String outBoundID;//出库交接单号
    private int handoverType;//出库交接单号
    private String line;//交接单类型
    private int direction;//线路资源
    private int acceptPerson;//物流方向
    private int carriers;//接货人
    private int deliveryPerson;//承运商
    private Date deliverDate;//出货人
    private String deliveryCompany;//出货单位
    private int enterPerson;//确认人
    private Date enterDate;//确认时间

    @Override
    public String toString() {
        return "SorOutBound{" +
                "outBoundID=" + outBoundID +
                ", handoverType=" + handoverType +
                ", line='" + line + '\'' +
                ", direction=" + direction +
                ", acceptPerson=" + acceptPerson +
                ", carriers=" + carriers +
                ", deliveryPerson=" + deliveryPerson +
                ", deliverDate=" + deliverDate +
                ", deliveryCompany='" + deliveryCompany + '\'' +
                ", enterPerson=" + enterPerson +
                ", enterDate=" + enterDate +
                '}';
    }

    public SorOutBound() {

    }

    public SorOutBound(String outBoundID, int handoverType, String line, int direction, int acceptPerson, int carriers, int deliveryPerson, Date deliverDate, String deliveryCompany, int enterPerson, Date enterDate) {
        this.outBoundID = outBoundID;
        this.handoverType = handoverType;
        this.line = line;
        this.direction = direction;
        this.acceptPerson = acceptPerson;
        this.carriers = carriers;
        this.deliveryPerson = deliveryPerson;
        this.deliverDate = deliverDate;
        this.deliveryCompany = deliveryCompany;
        this.enterPerson = enterPerson;
        this.enterDate = enterDate;
    }

    public String getOutBoundID() {
        return outBoundID;
    }

    public void setOutBoundID(String outBoundID) {
        this.outBoundID = outBoundID;
    }

    public int getHandoverType() {
        return handoverType;
    }

    public void setHandoverType(int handoverType) {
        this.handoverType = handoverType;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getAcceptPerson() {
        return acceptPerson;
    }

    public void setAcceptPerson(int acceptPerson) {
        this.acceptPerson = acceptPerson;
    }

    public int getCarriers() {
        return carriers;
    }

    public void setCarriers(int carriers) {
        this.carriers = carriers;
    }

    public int getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(int deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public int getEnterPerson() {
        return enterPerson;
    }

    public void setEnterPerson(int enterPerson) {
        this.enterPerson = enterPerson;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }
}
