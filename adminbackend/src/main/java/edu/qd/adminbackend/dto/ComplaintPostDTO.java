package edu.qd.adminbackend.dto;

import edu.qd.adminbackend.domain.ComplaintPost;

import java.io.Serializable;

public class ComplaintPostDTO extends ComplaintPost implements Serializable {

    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
