package com.liujie.result;

import com.liujie.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum enumm) {
        this.status = enumm.getCode();
        this.message = enumm.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
