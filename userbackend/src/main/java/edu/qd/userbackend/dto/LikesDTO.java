package edu.qd.userbackend.dto;

import java.io.Serializable;

public class LikesDTO implements Serializable {

    private long post;

    private int cmtId;

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
}
