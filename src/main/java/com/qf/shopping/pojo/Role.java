package com.qf.shopping.pojo;

public class Role {
    private Integer rId;

    private String rName;

    private String rDes;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrDes() {
        return rDes;
    }

    public void setrDes(String rDes) {
        this.rDes = rDes == null ? null : rDes.trim();
    }
}