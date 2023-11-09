package com.ziyou.core.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author libo
 * @date 2023/10/26
 */
@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS(0, "success"),
    FAIL(1, "error");
    private Integer code;
    private String msg;
}
