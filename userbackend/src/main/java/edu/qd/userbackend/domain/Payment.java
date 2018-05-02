package edu.qd.userbackend.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Payment implements Serializable {

    private static final long serialVersionUID = -375889641935133578L;

    private String code;

    private long user;

    private int status;

    private String wechat;

    private Timestamp creatime;

    public Payment() {
    }

    public Payment(String code, long user, int status, String wechat, Timestamp creatime) {
        this.code = code;
        this.user = user;
        this.status = status;
        this.wechat = wechat;
        this.creatime = creatime;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "code='" + code + '\'' +
                ", user=" + user +
                ", status=" + status +
                ", wechat='" + wechat + '\'' +
                ", creatime=" + creatime +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }

}


