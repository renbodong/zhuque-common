package com.github.zhuque.core.exception;

import com.github.zhuque.core.exception.code.ExceptionCode;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/6/2 22:32
 */
public class BizException extends BaseUnCheckException {

    private static final long serialVersionUID = -1414073965331794908L;

    public BizException(int code, String message) {
        super(code, message);
    }

    public BizException(int code, String message, Object... args) {
        super(code, message, args);
    }

    public BizException(String message) {
        super(-1,message);
    }

    public static BizException wrap(int code,String message){
        return new BizException(code,message);
    }

    public static BizException wrap(String message){
        return new BizException(-1,message);
    }

    public static BizException validFail(String message){
        return new BizException(-9,message);
    }

    public static BizException wrap(ExceptionCode ex){
        return new BizException(ex.getCode(),ex.getMessage());
    }

    @Override
    public String toString() {
        return "BizException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
