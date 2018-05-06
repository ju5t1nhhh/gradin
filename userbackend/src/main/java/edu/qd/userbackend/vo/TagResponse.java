package edu.qd.userbackend.vo;

public class TagResponse {

    private String name;

    private int times;

    public TagResponse() {
    }

    public TagResponse(String name, int times) {
        this.name = name;
        this.times = times;
    }

    @Override
    public String toString() {
        return "TagResponse{" +
                "name='" + name + '\'' +
                ", times=" + times +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
