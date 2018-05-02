package edu.qd.userbackend.domain;

import java.io.Serializable;

public class Follow implements Serializable {

    private static final long serialVersionUID = 3049266248096016101L;

    private long user;

    private long forUser;

    public Follow() {
    }

    public Follow(long user, long forUser) {
        this.user = user;
        this.forUser = forUser;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "user=" + user +
                ", forUser=" + forUser +
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

    public long getForUser() {
        return forUser;
    }

    public void setForUser(long forUser) {
        this.forUser = forUser;
    }
}
