package com.qf.shopping.pojo;

public class Address {
    private Integer addId;

    private String addDetail;

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public String getAddDetail() {
        return addDetail;
    }

    public void setAddDetail(String addDetail) {
        this.addDetail = addDetail == null ? null : addDetail.trim();
    }
}