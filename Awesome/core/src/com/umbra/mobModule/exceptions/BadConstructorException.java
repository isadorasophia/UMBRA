package com.umbra.mobModule.exceptions;


public class BadConstructorException extends Exception {
    public BadConstructorException() {
        super();
    }
    public BadConstructorException(String message) {
        super(message);
    }
    public BadConstructorException(String message, Throwable cause) {
        super(message, cause);
    }
    public BadConstructorException(Throwable cause) {
        super(cause);
    }
}
