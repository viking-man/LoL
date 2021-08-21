package com.viking.infrustructure.exception;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
public class BusinessException extends BaseException {

    BusinessException(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public BusinessException(String message) {
        this.setCode("10000");
        this.setMessage(message);
    }
}
