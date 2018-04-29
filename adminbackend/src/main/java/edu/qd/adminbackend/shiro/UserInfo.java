package edu.qd.adminbackend.shiro;

import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;

public class UserInfo implements Serializable, AuthCachePrincipal {

    private static final long serialVersionUID = 5184130151816713646L;

    private String username;

    public UserInfo() {
    }

    public UserInfo(String username) {
        this.username = username;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getAuthCacheKey() {
        return getUsername();
    }
}
