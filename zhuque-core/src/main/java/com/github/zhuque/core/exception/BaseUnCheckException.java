package com.github.zhuque.core.exception;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/6/2 22:27
 */
public class BaseUnCheckException extends RuntimeException implements BaseException {
    private static final long serialVersionUID = 3947432668407122659L;

    protected int code;

    protected String message;


    public BaseUnCheckException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseUnCheckException(int code, String message, Object... args) {
        super(String.format(message,args));
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }


    @Override
    public int getCode() {
        return code;
    }
}
