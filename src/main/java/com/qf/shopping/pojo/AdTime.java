package com.qf.shopping.pojo;

import java.util.Date;

public class AdTime {
    private Integer adId;

    private Date adStartTime;

    private Date adEndTime;

    private String adDetail;

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Date getAdStartTime() {
        return adStartTime;
    }

    public void setAdStartTime(Date adStartTime) {
        this.adStartTime = adStartTime;
    }

    public Date getAdEndTime() {
        return adEndTime;
    }

    public void setAdEndTime(Date adEndTime) {
        this.adEndTime = adEndTime;
    }

    public String getAdDetail() {
        return adDetail;
    }

    public void setAdDetail(String adDetail) {
        this.adDetail = adDetail == null ? null : adDetail.trim();
    }
}