package edu.qd.adminbackend.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class LogRecord implements Serializable {

    private static final long serialVersionUID = 6546516821788410171L;

    private String admin;

    private String text;

    private Timestamp creatime;

    public LogRecord() {
    }

    public LogRecord(String admin, String text, Timestamp creatime) {
        this.admin = admin;
        this.text = text;
        this.creatime = creatime;
    }

    @Override
    public String toString() {
        return "LogRecord{" +
                "admin='" + admin + '\'' +
                ", text='" + text + '\'' +
                ", creatime=" + creatime +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }

}

