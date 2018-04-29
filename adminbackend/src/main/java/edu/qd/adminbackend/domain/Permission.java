package edu.qd.adminbackend.domain;

import java.io.Serializable;

public class Permission implements Serializable {

    private static final long serialVersionUID = -8213063669306349455L;

    private int id;

    private String name;

    private String url;

    private int type;

    private int parent;

    public Permission() {
    }

    public Permission(int id, String name, String url, int type, int parent) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.type = type;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", type=" + type +
                ", parent=" + parent +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

}
