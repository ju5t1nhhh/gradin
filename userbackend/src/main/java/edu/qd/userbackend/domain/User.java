package edu.qd.userbackend.domain;

import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;

public class User implements Serializable, AuthCachePrincipal {

    private static final long serialVersionUID = 6348655815966846914L;

    private long autoId;

    private String id;

    private String email;

    private int status;

    private String pwd;

    private int gins;

    public User() {
    }

    public User(String id, String email, int status, String pwd, int gins) {
        this.id = id;
        this.email = email;
        this.status = status;
        this.pwd = pwd;
        this.gins = gins;
    }

    @Override
    public String toString() {
        return "User{" +
                "autoId=" + autoId +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", pwd='" + pwd + '\'' +
                ", gins=" + gins +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getAutoId() {
        return autoId;
    }

    public void setAutoId(long autoId) {
        this.autoId = autoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getGins() {
        return gins;
    }

    public void setGins(int gins) {
        this.gins = gins;
    }

    @Override
    public String getAuthCacheKey() {
        return String.valueOf(getAutoId());
    }
}
