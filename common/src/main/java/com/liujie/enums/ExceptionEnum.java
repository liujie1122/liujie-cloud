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
    SERVER_ERROR(500, "系统发生异常!"),
//    SERVER_SUCCESED(200, "操作成功!"),
    PRICE_CANNOT_BE_NULL(400, "价格不能为空!"),
    USER_ID_BE_NULL(400, "用户id不能为空!"),
    USER_NOT_FIND(404, "用户不存在!"),
    ;
    int code;
    String msg;

}




