package com.zhaomsdemo.research.schooling.config;

import com.zhaomsdemo.research.schooling.exception.DataNotFoundException;
import com.zhaomsdemo.research.schooling.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handleDataNotFoundException(DataNotFoundException e) {
        return Result.fail(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
