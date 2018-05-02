package edu.qd.userbackend.domain;

import java.io.Serializable;

public class Tag implements Serializable {

    private static final long serialVersionUID = 7996130090980682437L;

    private String name;

    private long post;

    public Tag() {
    }

    public Tag(String name, long post) {
        this.name = name;
        this.post = post;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", post=" + post +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPost() {
        return post;
    }

    public void setPost(long post) {
        this.post = post;
    }
}
