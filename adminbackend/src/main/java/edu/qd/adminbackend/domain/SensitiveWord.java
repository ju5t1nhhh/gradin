package edu.qd.adminbackend.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;

public class SensitiveWord implements Serializable {

    private static final long serialVersionUID = -6807248198104676859L;

    @Positive
    private int section;

    @NotBlank
    private String word;

    private String replace;

    public SensitiveWord() {
    }

    public SensitiveWord(int section, String word, String replace) {
        this.section = section;
        this.word = word;
        this.replace = replace;
    }

    @Override
    public String toString() {
        return "SensitiveWord{" +
                "section=" + section +
                ", word='" + word + '\'' +
                ", replace='" + replace + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

}
