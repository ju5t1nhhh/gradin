package edu.qd.userbackend.domain;

import java.io.Serializable;

public class UserDetail implements Serializable {

    private static final long serialVersionUID = 8393096034826318238L;

    private long user;

    private String avatar;

    private String brief;

    private String website;

    private String phone;

    private char gender;

    private String wechat;

    public UserDetail() {
    }

    public UserDetail(long user, String avatar, String brief, String website, String phone, char gender, String wechat) {
        this.user = user;
        this.avatar = avatar;
        this.brief = brief;
        this.website = website;
        this.phone = phone;
        this.gender = gender;
        this.wechat = wechat;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "user=" + user +
                ", avatar='" + avatar + '\'' +
                ", brief='" + brief + '\'' +
                ", website='" + website + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", wechat='" + wechat + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
