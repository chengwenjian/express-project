package com.aaa.entity;
//快递类型
public class Expresstype {
    private Integer Exptypeid;
    private String exptype;
    private String exptime;

    public Integer getExptypeid() {
        return Exptypeid;
    }

    public void setExptypeid(Integer exptypeid) {
        Exptypeid = exptypeid;
    }

    public String getExptype() {
        return exptype;
    }

    public void setExptype(String exptype) {
        this.exptype = exptype;
    }

    public String getExptime() {
        return exptime;
    }

    public void setExptime(String exptime) {
        this.exptime = exptime;
    }
}
