package edu.qd.adminbackend.dto;

import edu.qd.adminbackend.domain.Post;

import java.io.Serializable;

public class PostDTO extends Post implements Serializable {

    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
