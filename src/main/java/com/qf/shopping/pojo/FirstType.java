package com.qf.shopping.pojo;

public class FirstType {
    private Integer firstTypeId;

    private String firstTypeName;

    public Integer getFirstTypeId() {
        return firstTypeId;
    }

    public void setFirstTypeId(Integer firstTypeId) {
        this.firstTypeId = firstTypeId;
    }

    public String getFirstTypeName() {
        return firstTypeName;
    }

    public void setFirstTypeName(String firstTypeName) {
        this.firstTypeName = firstTypeName == null ? null : firstTypeName.trim();
    }
}