package com.liujie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum WE {
    PRICE_CANNOT_BE_NULL(40, "价格不能为空!"),
    ;
    int code1;
    String msg2;

}
