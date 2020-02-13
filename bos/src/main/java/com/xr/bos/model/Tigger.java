package com.xr.bos.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_schedule_trigger")
public class Tigger {

    @Id
    @GenericGenerator(name = "mysqlNative", strategy = "native")
    @GeneratedValue(generator = "mysqlNative")
    private Integer id;
    private String jobName;        //任务名称
    private String jobGroup;       //任务分组名称
    private String jobClass;       //任务类：填写Job类的完整类名
    private String jobDesc;        //任务描述
    private String cron;            //Cron表达式
    private String triggerName;    //触发器名称
    private String triggerGroup;   //触发器分组名称
    private String triggerDesc;    //触发器描述
    private int status;             //状态：0禁用 1启用
    private int account;            //添加人
    private Date createTime;       //添加时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getTriggerDesc() {
        return triggerDesc;
    }

    public void setTriggerDesc(String triggerDesc) {
        this.triggerDesc = triggerDesc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Tigger() {

    }

    public Tigger(String jobName, String jobGroup, String jobClass, String jobDesc, String cron, String triggerName, String triggerGroup, String triggerDesc, int status, int account, Date createTime) {
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.jobClass = jobClass;
        this.jobDesc = jobDesc;
        this.cron = cron;
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
        this.triggerDesc = triggerDesc;
        this.status = status;
        this.account = account;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Trigger{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", jobClass='" + jobClass + '\'' +
                ", jobDesc='" + jobDesc + '\'' +
                ", cron='" + cron + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", triggerGroup='" + triggerGroup + '\'' +
                ", triggerDesc='" + triggerDesc + '\'' +
                ", status=" + status +
                ", account=" + account +
                ", createTime=" + createTime +
                '}';
    }
}
