package edu.qd.adminbackend.domain;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ComplaintPost implements Serializable {

    private static final long serialVersionUID = 3940041506870860671L;

    private long post;

    private int cmtid;

    private int times;

    private int status;

    public ComplaintPost() {
    }

    public ComplaintPost(long post, int cmtid, int times, int status) {
        this.post = post;
        this.cmtid = cmtid;
        this.times = times;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ComplaintPost{" +
                "post=" + post +
                ", cmtid=" + cmtid +
                ", times=" + times +
                ", status=" + status +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

