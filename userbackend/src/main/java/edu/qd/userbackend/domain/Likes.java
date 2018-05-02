package edu.qd.userbackend.domain;

import java.io.Serializable;

public class Likes implements Serializable {

    private static final long serialVersionUID = 8870773242283693036L;

    private long post;

    private int cmtId;

    private long liker;

    public Likes() {
    }

    public Likes(long post, int cmtId, long liker) {
        this.post = post;
        this.cmtId = cmtId;
        this.liker = liker;
    }

    @Override
    public String toString() {
        return "Likes{" +
                "post=" + post +
                ", cmtId=" + cmtId +
                ", liker=" + liker +
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

    public int getCmtId() {
        return cmtId;
    }

    public void setCmtId(int cmtId) {
        this.cmtId = cmtId;
    }

    public long getLiker() {
        return liker;
    }

    public void setLiker(long liker) {
        this.liker = liker;
    }
}
