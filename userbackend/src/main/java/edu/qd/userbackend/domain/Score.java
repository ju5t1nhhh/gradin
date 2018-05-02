package edu.qd.userbackend.domain;

import java.io.Serializable;

public class Score implements Serializable {

    private static final long serialVersionUID = 3615675787709455942L;

    private long user;

    private long post;

    private int score;

    public Score() {
    }

    public Score(long user, long post, int score) {
        this.user = user;
        this.post = post;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "user=" + user +
                ", post=" + post +
                ", score=" + score +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getPost() {
        return post;
    }

    public void setPost(long post) {
        this.post = post;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
