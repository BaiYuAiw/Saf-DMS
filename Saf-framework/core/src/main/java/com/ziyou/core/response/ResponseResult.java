package com.ziyou.core.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author libo
 * @date 2023/10/26
 */

//保证json序列化的时候如何属性为null，key也一起消失
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    private ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResponseResult(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    private ResponseResult(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }

    @JsonIgnore
    @JSONField(serialize = false)
    public boolean isSuccess() {
        return this.code.equals(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<T>(ResponseCode.SUCCESS);
    }

    public static <T> ResponseResult<T> fail() {
        return new ResponseResult<T>(ResponseCode.FAIL);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(ResponseCode.SUCCESS, data);
    }

    public static <T> ResponseResult<T> fail(T data) {
        return new ResponseResult<T>(ResponseCode.FAIL, data);
    }

    public static <T> ResponseResult<T> fail(Integer code, String msg) {
        return new ResponseResult<T>(code, msg);
    }


}
