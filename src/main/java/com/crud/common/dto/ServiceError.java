package com.crud.common.dto;

public class ServiceError {
    String msg;
    String errorCode;

    public ServiceError() {
    }

    public ServiceError(String msg, String errorCode) {
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
