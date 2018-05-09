package edu.qd.adminbackend.dto;

import edu.qd.adminbackend.domain.Complaint;

import java.io.Serializable;

public class ComplaintDTO extends Complaint implements Serializable {

    private String date;

    private int page;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
