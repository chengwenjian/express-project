package com.aaa.entity;
//报价类型表
public class Offertype {
    private Integer offtyid;
    private String offertype;
    private Integer offerprice;
    private String offerremark;

    public Integer getOfftyid() {
        return offtyid;
    }

    public void setOfftyid(Integer offtyid) {
        this.offtyid = offtyid;
    }

    public String getOffertype() {
        return offertype;
    }

    public void setOffertype(String offertype) {
        this.offertype = offertype;
    }

    public Integer getOfferprice() {
        return offerprice;
    }

    public void setOfferprice(Integer offerprice) {
        this.offerprice = offerprice;
    }

    public String getOfferremark() {
        return offerremark;
    }

    public void setOfferremark(String offerremark) {
        this.offerremark = offerremark;
    }
}
