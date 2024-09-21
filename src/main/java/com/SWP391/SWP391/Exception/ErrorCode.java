package com.SWP391.SWP391.Exception;

public enum ErrorCode {
    USER_EXISTED(1001, "Username Existed, Try another username"),
    USERNAME_INVALID(1002,"Username must be at least 4 characters"),
    PASSWORD_INVALID(1003,"Password must be at least 6 characters"),
    USERNAME_NOTEXISTED(1004,"User not existed")

    ;
     ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
