package com.energic.exception;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.energic.pojo.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public <T> Result<T> handleException(final Exception exception) {
        exception.printStackTrace();
        return Result.error(
                StringUtils.hasLength(exception.getMessage())
                        ? exception.getMessage()
                        : "操作失败");
    }
}
