package com.common.exception;


public class PublicException extends RuntimeException {

    public PublicException() {
        super();
    }

    public PublicException(Throwable e) {
        super(e);
    }

    public PublicException(String message) {
        super(message);
    }

    public PublicException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
