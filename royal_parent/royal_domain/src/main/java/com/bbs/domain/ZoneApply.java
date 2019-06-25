package com.bbs.domain;

import java.io.Serializable;


//新增板块
public class ZoneApply implements Serializable {

    private Integer applyZoneId;

    private String zoneName;//新增板块名字
    private String userName;//用户名
    private String reason;//申请原因

    private Integer status;//处理状态(未处理-0,已处理-1)
    private String statusStr;

    public String getStatusStr() {
        if (status != null) {
            if (status == 0) {
                statusStr = "未处理";
            }
            else  if (status == 1) {
                    statusStr = "已处理";
                }
            }

        return statusStr;
    }
    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Integer getApplyZoneId() {
        return applyZoneId;
    }

    public void setApplyZoneId(Integer applyZoneId) {
        this.applyZoneId = applyZoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
