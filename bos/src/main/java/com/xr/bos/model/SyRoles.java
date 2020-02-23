package com.xr.bos.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class SyRoles implements Serializable {
    private static final long serialVersionUID = 5009777735783487038L;
    private Integer id;
    private String roleName;
    private String roleDesc;
    private  int  disabled;
    public SyRoles(){


    }

    public SyRoles(Integer id, String roleName, String roleDesc, int disabled) {
        this.id = id;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.disabled = disabled;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public int getDisabled() {
        return disabled;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "SyRoles{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", disabled=" + disabled +
                '}';
    }
}
