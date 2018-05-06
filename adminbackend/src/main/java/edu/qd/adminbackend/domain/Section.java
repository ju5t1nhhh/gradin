package edu.qd.adminbackend.domain;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class Section implements Serializable {

    private static final long serialVersionUID = 5402940209101541393L;

    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String intro;

    private String url;

    public Section() {
    }

    public Section(int id, String name, String intro, String url) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", url='" + url + '\'' +
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
