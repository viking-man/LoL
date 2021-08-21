package com.viking.infrustructure.exception;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
public class BaseException extends Throwable {

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
