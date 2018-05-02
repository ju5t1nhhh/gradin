package edu.qd.userbackend.domain;

import java.io.Serializable;

public class Gain implements Serializable {

    private static final long serialVersionUID = 5783189080312527295L;

    private long post;

    private long giver;

    private int gins;

    public Gain() {
    }

    public Gain(long post, long giver, int gins) {
        this.post = post;
        this.giver = giver;
        this.gins = gins;
    }

    @Override
    public String toString() {
        return "Gain{" +
                "post=" + post +
                ", giver=" + giver +
                ", gins=" + gins +
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

    public long getGiver() {
        return giver;
    }

    public void setGiver(long giver) {
        this.giver = giver;
    }

    public int getGins() {
        return gins;
    }

    public void setGins(int gins) {
        this.gins = gins;
    }
}
