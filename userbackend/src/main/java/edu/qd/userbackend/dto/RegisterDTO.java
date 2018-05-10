package edu.qd.userbackend.dto;

import java.io.Serializable;

public class RegisterDTO implements Serializable {

    private String id;

    private String pwd;

    private String email;

    private String ecode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }
}
