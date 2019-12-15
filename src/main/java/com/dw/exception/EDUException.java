package com.dw.exception;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


public class EDUException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;
    private int code = 500;

    public EDUException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public EDUException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public EDUException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public EDUException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
