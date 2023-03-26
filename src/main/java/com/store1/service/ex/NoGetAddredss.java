package com.store1.service.ex;

/**
 * 判斷數據庫裡面返回前端的異常
 */
public class NoGetAddredss extends ServiceException {
    public NoGetAddredss() {
        super();
    }

    public NoGetAddredss(String message) {
        super(message);
    }

    public NoGetAddredss(String message, Throwable cause) {
        super(message, cause);
    }

    public NoGetAddredss(Throwable cause) {
        super(cause);
    }

    protected NoGetAddredss(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
