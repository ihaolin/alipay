package me.hao0.alipay.exception;

/**
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 11/11/15
 */
public class AliPayException extends RuntimeException {
    public AliPayException() {
        super();
    }

    public AliPayException(String message) {
        super(message);
    }

    public AliPayException(String message, Throwable cause) {
        super(message, cause);
    }

    public AliPayException(Throwable cause) {
        super(cause);
    }

    protected AliPayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
