package com.xr.bos.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class SorStorage {
    private Integer ID;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date acceptDate;
    private Integer acceptPerson;
    private String acceptCompany;
    private Integer deliveryPerson;
    private String deliveryCompany;

    public SorStorage(Integer ID, Date acceptDate, Integer acceptPerson, String acceptCompany, Integer deliveryPerson, String deliveryCompany) {
        this.ID = ID;
        this.acceptDate = acceptDate;
        this.acceptPerson = acceptPerson;
        this.acceptCompany = acceptCompany;
        this.deliveryPerson = deliveryPerson;
        this.deliveryCompany = deliveryCompany;
    }

    public SorStorage() {

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Integer getAcceptPerson() {
        return acceptPerson;
    }

    public void setAcceptPerson(Integer acceptPerson) {
        this.acceptPerson = acceptPerson;
    }

    public String getAcceptCompany() {
        return acceptCompany;
    }

    public void setAcceptCompany(String acceptCompany) {
        this.acceptCompany = acceptCompany;
    }

    public Integer getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(Integer deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    @Override
    public String toString() {
        return "SorStorage{" +
                "ID=" + ID +
                ", acceptDate=" + acceptDate +
                ", acceptPerson=" + acceptPerson +
                ", acceptCompany='" + acceptCompany + '\'' +
                ", deliveryPerson=" + deliveryPerson +
                ", deliveryCompany='" + deliveryCompany + '\'' +
                '}';
    }
}

