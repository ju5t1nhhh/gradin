package edu.qd.adminbackend.dto;

import edu.qd.adminbackend.domain.User;

import java.io.Serializable;

public class UserDTO extends User implements Serializable {

    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
