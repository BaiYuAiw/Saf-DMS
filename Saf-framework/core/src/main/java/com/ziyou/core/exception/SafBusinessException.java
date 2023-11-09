package com.ziyou.core.exception;

import com.ziyou.core.response.ResponseCode;
import lombok.Data;

/**
 * @author libo
 * @date 2023/10/27
 */
@Data
public class SafBusinessException extends RuntimeException {
    private Integer code;
    private String msg;

    public SafBusinessException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public SafBusinessException(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }
}
