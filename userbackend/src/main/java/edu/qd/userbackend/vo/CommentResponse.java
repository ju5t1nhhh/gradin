package edu.qd.userbackend.vo;

import edu.qd.userbackend.domain.Comment;

public class CommentResponse extends Comment {

    private int likes;

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
