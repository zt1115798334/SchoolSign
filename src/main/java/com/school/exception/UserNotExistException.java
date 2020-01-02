package com.school.exception;

public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户信息不存在");
    }
}
