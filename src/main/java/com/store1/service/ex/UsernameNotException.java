package com.store1.service.ex;

/**
 * 判斷登入時的帳號
 */
public class UsernameNotException extends ServiceException{
    public UsernameNotException() {
        super();
    }

    public UsernameNotException(String message) {
        super(message);
    }

    public UsernameNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameNotException(Throwable cause) {
        super(cause);
    }

    protected UsernameNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
