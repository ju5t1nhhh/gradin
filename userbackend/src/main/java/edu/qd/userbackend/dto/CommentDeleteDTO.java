package edu.qd.userbackend.dto;

import java.io.Serializable;

public class CommentDeleteDTO implements Serializable {

    private long post;

    private int cmtid;

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
}
