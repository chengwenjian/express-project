package com.aaa.entity;

public class TuserTwo {
    private Integer id;
    private String bz;
    private String password;
    private String truename;
    private String username;
    private String remarks;

    @Override
    public String toString() {
        return "TuserTwo{" +
                "id=" + id +
                ", bz='" + bz + '\'' +
                ", password='" + password + '\'' +
                ", truename='" + truename + '\'' +
                ", username='" + username + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

