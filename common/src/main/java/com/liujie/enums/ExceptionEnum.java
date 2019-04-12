package com.liujie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 异常信息枚举类
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  ExceptionEnum {
    PRICE_CANNOT_BE_NULL(400, "价格不能为空!"),
    ;
    int code;
    String msg;

}




