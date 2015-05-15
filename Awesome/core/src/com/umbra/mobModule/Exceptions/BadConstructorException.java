package com.umbra.mobModule.Exceptions;


public class BadConstructorException extends Throwable {
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
