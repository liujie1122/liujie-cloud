package com.liujie.advice;

import com.liujie.exception.MyException;
import com.liujie.result.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    /**
     * 自定义全局异常处理方法
     * @param me
     * @return
     */
    @ExceptionHandler(MyException.class)
    public ResponseEntity<ExceptionResult> handleException(MyException me){
        return ResponseEntity.status(me.getExceptionEnum().getCode())
                .body(new ExceptionResult(me.getExceptionEnum()));
    }




}

