package com.github.zhuque.core.exception;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/6/2 22:26
 */
public interface BaseException {
    int PARAM_VALID_FAIL = -9;

    int getCode();

    String getMessage();
}
