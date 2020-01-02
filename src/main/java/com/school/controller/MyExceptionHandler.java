package com.school.controller;

import com.google.common.collect.Maps;
import com.school.exception.UserNotExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity handlerException(Exception e, HttpServletRequest request) {
        Map<String, String> data = Maps.newConcurrentMap();
        data.put("message", e.getMessage());
        request.setAttribute("message",e.getMessage());
        return ResponseEntity.status(500).body(data);
    }
}
