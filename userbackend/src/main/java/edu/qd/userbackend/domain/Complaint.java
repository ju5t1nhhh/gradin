package edu.qd.userbackend.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Complaint implements Serializable {

    private static final long serialVersionUID = 3313021561519115711L;

    private long user;

    private long post;

    private int cmtid;

    private String msg;

    private Timestamp creatime;

    public Complaint() {
    }

    public Complaint(long user, long post, int cmtid, String msg, Timestamp creatime) {
        this.user = user;
        this.post = post;
        this.cmtid = cmtid;
        this.msg = msg;
        this.creatime = creatime;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "user=" + user +
                ", post=" + post +
                ", cmtid=" + cmtid +
                ", msg='" + msg + '\'' +
                ", creatime=" + creatime +
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

    public long getPost() {
        return post;
    }

    public void setPost(long post) {
        this.post = post;
    }

    public int getCmtid() {
        return cmtid;
    }

    public void setCmtid(int cmtid) {
        this.cmtid = cmtid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }

}


