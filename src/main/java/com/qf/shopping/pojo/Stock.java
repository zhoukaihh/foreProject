package com.qf.shopping.pojo;

public class Stock {
    private Integer stockId;

    private Integer goodId;

    private Integer goodStockNum;

    private Integer goodLockNum;

    private Integer goodWarnNum;

    private String _version;

    private String remark;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getGoodStockNum() {
        return goodStockNum;
    }

    public void setGoodStockNum(Integer goodStockNum) {
        this.goodStockNum = goodStockNum;
    }

    public Integer getGoodLockNum() {
        return goodLockNum;
    }

    public void setGoodLockNum(Integer goodLockNum) {
        this.goodLockNum = goodLockNum;
    }

    public Integer getGoodWarnNum() {
        return goodWarnNum;
    }

    public void setGoodWarnNum(Integer goodWarnNum) {
        this.goodWarnNum = goodWarnNum;
    }

    public String get_version() {
        return _version;
    }

    public void set_version(String _version) {
        this._version = _version == null ? null : _version.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}