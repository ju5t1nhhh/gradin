package edu.qd.userbackend.dto;

import java.io.Serializable;

public class ModEmailDTO implements Serializable {

    private String newEmail;

    private String emailCode;

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }
}
