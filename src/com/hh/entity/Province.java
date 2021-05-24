package com.hh.entity;

public class Province {
    private Integer provinceId;
    private String shenghui;
    private String jiancheng;
    private String name;

    public Province() {
    }

    public Province(Integer provinceId, String shenghui, String jiancheng, String name) {
        this.provinceId = provinceId;
        this.shenghui = shenghui;
        this.jiancheng = jiancheng;
        this.name = name;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getShenghui() {
        return shenghui;
    }

    public void setShenghui(String shenghui) {
        this.shenghui = shenghui;
    }

    public String getJiancheng() {
        return jiancheng;
    }

    public void setJiancheng(String jiancheng) {
        this.jiancheng = jiancheng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
