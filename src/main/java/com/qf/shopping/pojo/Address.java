package com.qf.shopping.pojo;

public class Address {
    private Integer addId;

    private String addDetail;

    private String addContactPhone;

    private String addContactName;

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

    public String getAddContactPhone() {
        return addContactPhone;
    }

    public void setAddContactPhone(String addContactPhone) {
        this.addContactPhone = addContactPhone == null ? null : addContactPhone.trim();
    }

    public String getAddContactName() {
        return addContactName;
    }

    public void setAddContactName(String addContactName) {
        this.addContactName = addContactName == null ? null : addContactName.trim();
    }
}