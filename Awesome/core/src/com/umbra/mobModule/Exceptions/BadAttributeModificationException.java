package com.umbra.mobModule.Exceptions;


public class BadAttributeModificationException extends Throwable {
    public BadAttributeModificationException() {
        super();
    }
    public BadAttributeModificationException(String message) {
        super(message);
    }
    public BadAttributeModificationException(String message, Throwable cause) {
        super(message, cause);
    }
    public BadAttributeModificationException(Throwable cause) {
        super(cause);
    }
}
