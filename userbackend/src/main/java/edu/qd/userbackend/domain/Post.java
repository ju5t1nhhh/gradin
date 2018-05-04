package edu.qd.userbackend.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Post implements Serializable {

    private static final long serialVersionUID = 6014315985808029109L;

    private long id;

    private long author;

    private String multmedia;

    private String[] medias;

    private String text;

    private int section;

    private Timestamp creatime;

    public Post() {
    }

    public Post(long author, String multmedia, String text, int section, Timestamp creatime) {
        this.author = author;
        this.multmedia = multmedia;
        this.text = text;
        this.section = section;
        this.creatime = creatime;
    }

    public void multToArrays() {
        this.medias=multmedia.split(",");
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author=" + author +
                ", multmedia='" + multmedia + '\'' +
                ", text='" + text + '\'' +
                ", section=" + section +
                ", creatime=" + creatime +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAuthor() {
        return author;
    }

    public void setAuthor(long author) {
        this.author = author;
    }

    public String getMultmedia() {
        return multmedia;
    }

    public void setMultmedia(String multmedia) {
        this.multmedia = multmedia;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }

}


