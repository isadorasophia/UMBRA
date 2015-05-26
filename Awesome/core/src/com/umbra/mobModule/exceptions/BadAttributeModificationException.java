package com.umbra.mobModule.exceptions;


public class BadAttributeModificationException extends Exception {
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
