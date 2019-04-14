package com.liujie.exception;

import com.liujie.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MyException extends RuntimeException {
    private ExceptionEnum exceptionEnum;
}
