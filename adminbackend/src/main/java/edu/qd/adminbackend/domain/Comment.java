package edu.qd.adminbackend.domain;

import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {

    private static final long serialVersionUID = -1322103434512088194L;

    @Positive
    private long post;

    @Positive
    private int cmtid;

    private long cmtor;

    private String cmtorid;

    private String text;

    private Timestamp creatime;

    public Comment() {
    }

    public Comment(long post, int cmtid, long cmtor, String cmtorid, String text, Timestamp creatime) {
        this.post = post;
        this.cmtid = cmtid;
        this.cmtor = cmtor;
        this.cmtorid = cmtorid;
        this.text = text;
        this.creatime = creatime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "post=" + post +
                ", cmtid=" + cmtid +
                ", cmtor=" + cmtor +
                ", cmtorid='" + cmtorid + '\'' +
                ", text='" + text + '\'' +
                ", creatime=" + creatime +
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

    public long getCmtor() {
        return cmtor;
    }

    public void setCmtor(long cmtor) {
        this.cmtor = cmtor;
    }

    public String getCmtorid() {
        return cmtorid;
    }

    public void setCmtorid(String cmtorid) {
        this.cmtorid = cmtorid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }

}

