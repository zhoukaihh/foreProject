package com.qf.shopping.pojo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Advertisment {
    private Integer adId;

    private String adType;

    private String actionUrl;

    private String imgPath;

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date adStartTime;

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType == null ? null : adType.trim();
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl == null ? null : actionUrl.trim();
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public Date getAdStartTime() {
        return adStartTime;
    }

    public void setAdStartTime(Date adStartTime) {
//    	Instant instant = adStartTime.toInstant();
//        ZoneId zoneId = ZoneId.systemDefault();
//
//        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        this.adStartTime = adStartTime;
    }
}