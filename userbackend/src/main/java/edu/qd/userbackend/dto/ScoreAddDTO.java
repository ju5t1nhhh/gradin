package edu.qd.userbackend.dto;

import java.io.Serializable;

public class ScoreAddDTO implements Serializable {

    private long post;

    private int score;

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
