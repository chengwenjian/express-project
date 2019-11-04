package com.aaa.entity;
//付款方式
public class Paymethod {
    private Integer payid;
    private String paytype;
    private String paynode;
    private String paytime;

    public Integer getPayid() {
        return payid;
    }

    public void setPayid(Integer payid) {
        this.payid = payid;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPaynode() {
        return paynode;
    }

    public void setPaynode(String paynode) {
        this.paynode = paynode;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }
}
