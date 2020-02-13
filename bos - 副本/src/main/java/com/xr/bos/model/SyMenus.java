package com.xr.bos.model;

import org.springframework.stereotype.Component;

@Component
public class SyMenus {
    private Integer ID;
    private String parentID;
    private String type;
    private String text;
    private String url;
    private String tip;
    private String icon;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public SyMenus() {
    }

    public SyMenus(Integer ID, String parentID, String type, String text, String url, String tip, String icon) {
        this.ID = ID;
        this.parentID = parentID;
        this.type = type;
        this.text = text;
        this.url = url;
        this.tip = tip;
        this.icon = icon;
    }
}
