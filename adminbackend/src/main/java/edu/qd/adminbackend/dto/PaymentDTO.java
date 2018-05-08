package edu.qd.adminbackend.dto;

import edu.qd.adminbackend.domain.Payment;

import java.io.Serializable;

public class PaymentDTO extends Payment implements Serializable {

    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
