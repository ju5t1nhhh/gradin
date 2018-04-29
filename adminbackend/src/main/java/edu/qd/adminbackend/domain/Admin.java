package edu.qd.adminbackend.domain;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class Admin implements Serializable {

    private static final long serialVersionUID = -5930623744900066729L;

    @NotBlank(message = "id不能空")
    private String loginId;

    @NotBlank(message = "密码不能空")
    private String pwd;

    @NotBlank(message = "角色不能空")
    private int role;

    public Admin(){}

    public Admin(String loginId, String pwd, int role) {
        this.loginId = loginId;
        this.pwd = pwd;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "loginId='" + loginId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", role=" + role +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}