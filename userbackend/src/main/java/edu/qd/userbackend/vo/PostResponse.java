package edu.qd.userbackend.vo;

import java.sql.Timestamp;

public class PostResponse {

    private String author;

    private String[] medias;

    private String text;

    private int section;

    private int score;

    private int scorers;

    private Timestamp creatime;

    public PostResponse() {
    }

    public PostResponse(String author, String[] medias, String text, int section, int score, int scorers, Timestamp creatime) {
        this.author = author;
        this.medias = medias;
        this.text = text;
        this.section = section;
        this.score = score;
        this.scorers = scorers;
        this.creatime = creatime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getMedias() {
        return medias;
    }

    public void setMedias(String[] medias) {
        this.medias = medias;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScorers() {
        return scorers;
    }

    public void setScorers(int scorers) {
        this.scorers = scorers;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }
}
