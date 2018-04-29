package edu.qd.adminbackend.domain;

import java.io.Serializable;

public class RolePermission implements Serializable {

    private static final long serialVersionUID = -5120942879460494901L;

    private int role;

    private int permission;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
