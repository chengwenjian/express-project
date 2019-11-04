package com.aaa.entity;
//客户表
public class Customer {
    private Integer custid;
    private String custnickname;
    private String custphone;
    private String custname;
    private String custidcord;
    private String custemail;
    private Integer brandid;
    private Integer custrank;

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public String getCustnickname() {
        return custnickname;
    }

    public void setCustnickname(String custnickname) {
        this.custnickname = custnickname;
    }

    public String getCustphone() {
        return custphone;
    }

    public void setCustphone(String custphone) {
        this.custphone = custphone;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustidcord() {
        return custidcord;
    }

    public void setCustidcord(String custidcord) {
        this.custidcord = custidcord;
    }

    public String getCustemail() {
        return custemail;
    }

    public void setCustemail(String custemail) {
        this.custemail = custemail;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public Integer getCustrank() {
        return custrank;
    }

    public void setCustrank(Integer custrank) {
        this.custrank = custrank;
    }
}
