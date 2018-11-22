package com.example.zdemo.Im.netty.transport.exception;

/**
 * 空参数异常.
 *
 */
public class NullParamsException extends RuntimeException {

    public NullParamsException() {
        super();
    }

    public NullParamsException(String messge) {
        super(messge);
    }

    public NullParamsException(Throwable cause) {
        super(cause);
    }

    public NullParamsException(String messge, Throwable cause) {
        super(messge, cause);
    }
}
