package com.github.zhuque.core.base;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.zhuque.core.exception.BizException;
import com.github.zhuque.core.exception.code.BaseExceptionCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/17 15:37
 */
@Getter
@Setter
@Accessors(chain = true)
public class R<T> {
    public static final String DEF_ERROR_MESSAGE = "系统繁忙，请稍后再试";
    public static final String HYSTRIX_ERROR_MESSAGE = "请求超时,请稍后再试";
    public static final int SUCCESS_CODE = 0;
    public static final int FAIL_CODE = -1;
    public static final int TIMEOUT_CODE = -2;
    /**
     * 统一参数验证异常
     */
    public static final int VALID_EX_CODE = -9;
    public static final int OPERATION_EX_CODE = -10;

    /**
     * 调用是否成功标志 0 成功 -1 系统繁忙 详见【ExceptionCode】
     */
    @ApiModelProperty(value = "相应编码 0/200-请求成功")
    private int code;

    /**
     * 是否执行默认操作
     *
     * @return
     */
    @JsonIgnore
    private Boolean defExec = true;

    @ApiModelProperty(value = "响应数据")
    private T data;

    @ApiModelProperty(value = "提示消息")
    private String msg = "ok";

    @ApiModelProperty(value = "请求路径")
    private String path;

    @ApiModelProperty(value = "附加数据")
    private Map<String,Object> extra;

    @ApiModelProperty("响应时间戳")
    private long timestamp = System.currentTimeMillis();

    public R(){
        super();
    }

    public R(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.defExec = false;
    }

    public R(int code,String msg,T data,boolean defExec){
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.defExec = defExec;
    }

    public static <E> R<E> result(int code, String msg, E data){
        return new R<>(code,msg,data);
    }

    /**
     * 请求成功的消息
     */

    public static <E> R<E> success(E data){
        return new R<>(SUCCESS_CODE,"ok",data);
    }

    public static R<Boolean> success(){
        return new R<>(SUCCESS_CODE,"ok",true);
    }


    public static <E> R<E> success(String msg,E data){
        return new R<>(SUCCESS_CODE,msg,data);
    }


    public static <E> R<E> successDef(E data){
        return new R<>(SUCCESS_CODE,"ok",data,true);
    }

    public static <E> R<E> successDef(){
        return new R<>(SUCCESS_CODE,"ok",null,true);
    }

    public static <E> R<E> successDef(String msg,E data){
        return new R<>(SUCCESS_CODE,msg,data,true);
    }

    /**
     * 请求失败的消息
     */

    public static <E> R<E> fail(int code,String msg){
        return new R<>(code,StrUtil.isEmpty(msg) ? DEF_ERROR_MESSAGE : msg,null);
    }

    public static <E> R<E> fail(String msg){
        return fail(OPERATION_EX_CODE,msg);
    }

    public static <E> R<E> fail(String msg,Object... args){
        msg = StrUtil.isEmpty(msg)?DEF_ERROR_MESSAGE:msg;
        return new R<>(OPERATION_EX_CODE,String.format(msg,args),null);
    }

    public static <E> R<E> fail(BaseExceptionCode exceptionCode) {
        return validFail(exceptionCode);
    }

    public static <E> R<E> fail(BizException exception) {
        if (exception == null) {
            return fail(DEF_ERROR_MESSAGE);
        }
        return new R<>(exception.getCode(),exception.getMessage(),null);
    }


    /**
     * 请求失败消息，根据异常类型，获取不同的提供消息
     *
     * @param throwable 异常
     * @return RPC调用结果
     */
    public static <E> R<E> fail(Throwable throwable) {
        return fail(FAIL_CODE, throwable != null ? throwable.getMessage() : DEF_ERROR_MESSAGE);
    }

    public static <E> R<E> validFail(String msg) {
        return new R<>(VALID_EX_CODE, (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg,null);
    }

    public static <E> R<E> validFail(String msg, Object... args) {
        String message = (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg;
        return new R<>(VALID_EX_CODE,  String.format(message, args),null);
    }

    public static <E> R<E> validFail(BaseExceptionCode exceptionCode) {
        return new R<>(exceptionCode.getCode(),
                (exceptionCode.getMessage() == null || exceptionCode.getMessage().isEmpty()) ? DEF_ERROR_MESSAGE :
                        exceptionCode
                        .getMessage(),null);
    }


    public static <E> R<E> timeout() {
        return fail(TIMEOUT_CODE, HYSTRIX_ERROR_MESSAGE);
    }


    public R<T> put(String key, Object value) {
        if (this.extra == null) {
            this.extra = new HashMap<>(10);
        }
        this.extra.put(key, value);
        return this;
    }

    /**
     * 逻辑处理是否成功
     *
     * @return 是否成功
     */
    public Boolean getIsSuccess() {
        return this.code == SUCCESS_CODE || this.code == 200;
    }

    /**
     * 逻辑处理是否失败
     *
     * @return
     */
    public Boolean getIsError() {
        return !getIsSuccess();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
