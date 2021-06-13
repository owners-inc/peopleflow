package com.workmotion.io.peopleflow.model.exceptions;

public class BasicException extends RuntimeException {

    private int statusCode;
    private String msg;

    public BasicException() {
    }

    public BasicException(int statusCode,String message) {
        this.statusCode = statusCode;
        this.msg = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
