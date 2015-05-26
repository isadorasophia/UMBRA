package com.umbra.vultoModule;

public class UnknownInputException extends Throwable {
    public UnknownInputException() {
        super();
    }
    public UnknownInputException(String message) {
        super(message);
    }
    public UnknownInputException(String message, Throwable cause) {
        super(message, cause);
    }
    public UnknownInputException(Throwable cause) {
        super(cause);
    }
}
