package edu.qd.userbackend.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {

    private static final long serialVersionUID = -8663881235855536016L;

    private long rcvder;

    private String senderId;

    private String text;

    private int status;

    private Timestamp creatime;

    public Message() {
    }

    public Message(long rcvder, String senderId, String text, int status, Timestamp creatime) {
        this.rcvder = rcvder;
        this.senderId = senderId;
        this.text = text;
        this.status = status;
        this.creatime = creatime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "rcvder=" + rcvder +
                ", senderId='" + senderId + '\'' +
                ", text='" + text + '\'' +
                ", status=" + status +
                ", creatime=" + creatime +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getRcvder() {
        return rcvder;
    }

    public void setRcvder(long rcvder) {
        this.rcvder = rcvder;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }
}
