package edu.qd.adminbackend.vo;

import java.io.Serializable;

public class RestResponse implements Serializable {

    private static final long serialVersionUID = 3049514793416452084L;

    private int code;

    private String msg;

    private Object data;

    public RestResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static RestResponse successWithMsg(String msg) {
        return new RestResponse(200, msg, null);
    }

    public static RestResponse successWithData(String msg, Object data) {
        return new RestResponse(200, msg, data);
    }

    public static RestResponse errorWithMsg(int code, String msg) {
        return new RestResponse(code, msg, null);
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
