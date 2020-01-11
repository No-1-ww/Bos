package com.xr.bos.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class SyEmp implements Serializable {
    private Integer ID;
    private String empName;
    private String empNo;
    private String pwd;
    private String queryPwd;
    private Integer roleID;

    private String phone;
    private String photo;

    private Integer empUnit;
    private String remark;
    private String disabled;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getQueryPwd() {
        return queryPwd;
    }

    public void setQueryPwd(String queryPwd) {
        this.queryPwd = queryPwd;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getEmpUnit() {
        return empUnit;
    }

    public void setEmpUnit(Integer empUnit) {
        this.empUnit = empUnit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public SyEmp() {

    }

    public SyEmp(Integer ID, String empName, String empNo, String pwd, String queryPwd, Integer roleID, String phone, String photo, Integer empUnit, String remark, String disabled) {
        this.ID = ID;
        this.empName = empName;
        this.empNo = empNo;
        this.pwd = pwd;
        this.queryPwd = queryPwd;
        this.roleID = roleID;
        this.phone = phone;
        this.photo = photo;
        this.empUnit = empUnit;
        this.remark = remark;
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "SyEmp{" +
                "ID=" + ID +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", pwd='" + pwd + '\'' +
                ", queryPwd='" + queryPwd + '\'' +
                ", roleID=" + roleID +
                ", phone='" + phone + '\'' +
                ", photo='" + photo + '\'' +
                ", empUnit=" + empUnit +
                ", remark='" + remark + '\'' +
                ", disabled='" + disabled + '\'' +
                '}';
    }
}
