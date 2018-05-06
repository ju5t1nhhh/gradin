package edu.qd.userbackend.vo;

public class UserResponse {

    private String id;

    private String email;

    private int gins;

    private String avatar;

    private int follows;

    private int fans;

    private int posts;

    private int msgstatus;

    public UserResponse() {
    }

    public UserResponse(String id, String email, int gins, String avatar, int follows, int fans, int posts, int msgstatus) {
        this.id = id;
        this.email = email;
        this.gins = gins;
        this.avatar = avatar;
        this.follows = follows;
        this.fans = fans;
        this.posts = posts;
        this.msgstatus = msgstatus;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", gins=" + gins +
                ", avatar='" + avatar + '\'' +
                ", follows=" + follows +
                ", fans=" + fans +
                ", posts=" + posts +
                ", msgstatus=" + msgstatus +
                '}';
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

    public int getGins() {
        return gins;
    }

    public void setGins(int gins) {
        this.gins = gins;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public int getMsgstatus() {
        return msgstatus;
    }

    public void setMsgstatus(int msgstatus) {
        this.msgstatus = msgstatus;
    }
}
