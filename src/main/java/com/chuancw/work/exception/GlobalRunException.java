package com.chuancw.work.exception;

public class GlobalRunException extends RuntimeException{

    public GlobalRunException() {
    }

    public GlobalRunException(String message) {
        super(message);
    }

    public GlobalRunException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalRunException(Throwable cause) {
        super(cause);
    }
}
