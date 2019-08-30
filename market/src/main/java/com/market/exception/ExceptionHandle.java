package com.market.exception;

import com.market.domain.ChartResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public ChartResult handleException(Exception e) {
        e.printStackTrace();
        if (e instanceof CustomException) {
            return ChartResult.build(400, e.getMessage());
        } else {
            return ChartResult.build(400, "未知错误：" + e.getMessage());
        }
    }
}
