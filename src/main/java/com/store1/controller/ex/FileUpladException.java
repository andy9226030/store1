package com.store1.controller.ex;

/**
 * 控制層的基本類
 */
public class FileUpladException extends RuntimeException{
    public FileUpladException() {
        super();
    }

    public FileUpladException(String message) {
        super(message);
    }

    public FileUpladException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUpladException(Throwable cause) {
        super(cause);
    }

    protected FileUpladException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
