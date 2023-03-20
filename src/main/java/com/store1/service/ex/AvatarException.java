package com.store1.service.ex;

/**
 * 判斷照片是否上傳成功
 */
public class AvatarException extends ServiceException {
    public AvatarException() {
        super();
    }

    public AvatarException(String message) {
        super(message);
    }

    public AvatarException(String message, Throwable cause) {
        super(message, cause);
    }

    public AvatarException(Throwable cause) {
        super(cause);
    }

    protected AvatarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
