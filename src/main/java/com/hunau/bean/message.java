package com.hunau.bean;

/**
 * @author Wking
 * @create 2020-12-04 17:12
 */
public class message {
    String msg;
    boolean flag;

    public message() {
    }

    public message(String msg, boolean flag) {
        this.msg = msg;
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "message{" +
                "msg='" + msg + '\'' +
                ", flag=" + flag +
                '}';
    }
}
