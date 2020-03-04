package com.xr.bos.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class Ret_returnlist {
    private Integer id;
    private String applicationNo;
    private String workSheetNo;
    private Integer returnType;
    private String apRemark;
    private Integer aApLoss;
    private Date entryTime;
    private String receivegUnit;
    private Integer invalidateSign;
    private String returnUnit;
    private Date recordingTime;
    private String entryUnit;
    private String personName;
    private Date confirmationTime;
    private String confirmationUnit;
    private String confirmationPersonName;
    private Integer treatmentState;
    private Integer apReturnStatus;
    private Integer identificationSign;
    private String handlingOpinions;
    private String denialType;

    public Ret_returnlist() {
    }

    public Ret_returnlist(Integer id, String applicationNo, String workSheetNo, Integer returnType, String apRemark, Integer aApLoss, Date entryTime, String receivegUnit, Integer invalidateSign, String returnUnit, Date recordingTime, String entryUnit, String personName, Date confirmationTime, String confirmationUnit, String confirmationPersonName, Integer treatmentState, Integer apReturnStatus, Integer identificationSign, String handlingOpinions, String denialType) {
        this.id = id;
        this.applicationNo = applicationNo;
        this.workSheetNo = workSheetNo;
        this.returnType = returnType;
        this.apRemark = apRemark;
        this.aApLoss = aApLoss;
        this.entryTime = entryTime;
        this.receivegUnit = receivegUnit;
        this.invalidateSign = invalidateSign;
        this.returnUnit = returnUnit;
        this.recordingTime = recordingTime;
        this.entryUnit = entryUnit;
        this.personName = personName;
        this.confirmationTime = confirmationTime;
        this.confirmationUnit = confirmationUnit;
        this.confirmationPersonName = confirmationPersonName;
        this.treatmentState = treatmentState;
        this.apReturnStatus = apReturnStatus;
        this.identificationSign = identificationSign;
        this.handlingOpinions = handlingOpinions;
        this.denialType = denialType;
    }

    @Override
    public String toString() {
        return "Ret_returnlist{" +
                "id=" + id +
                ", applicationNo='" + applicationNo + '\'' +
                ", workSheetNo='" + workSheetNo + '\'' +
                ", returnType=" + returnType +
                ", apRemark='" + apRemark + '\'' +
                ", aApLoss=" + aApLoss +
                ", entryTime=" + entryTime +
                ", receivegUnit='" + receivegUnit + '\'' +
                ", invalidateSign=" + invalidateSign +
                ", returnUnit='" + returnUnit + '\'' +
                ", recordingTime=" + recordingTime +
                ", entryUnit='" + entryUnit + '\'' +
                ", personName='" + personName + '\'' +
                ", confirmationTime=" + confirmationTime +
                ", confirmationUnit='" + confirmationUnit + '\'' +
                ", confirmationPersonName='" + confirmationPersonName + '\'' +
                ", treatmentState=" + treatmentState +
                ", apReturnStatus=" + apReturnStatus +
                ", identificationSign=" + identificationSign +
                ", handlingOpinions='" + handlingOpinions + '\'' +
                ", denialType='" + denialType + '\'' +
                '}';
    }
}
