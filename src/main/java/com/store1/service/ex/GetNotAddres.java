package com.store1.service.ex;

/**
 * 查詢不到
 */
public class GetNotAddres extends ServiceException{
    public GetNotAddres() {
        super();
    }

    public GetNotAddres(String message) {
        super(message);
    }

    public GetNotAddres(String message, Throwable cause) {
        super(message, cause);
    }

    public GetNotAddres(Throwable cause) {
        super(cause);
    }

    protected GetNotAddres(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
