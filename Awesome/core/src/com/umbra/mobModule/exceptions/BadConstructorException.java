package com.umbra.mobModule.exceptions;

public class BadConstructorException extends Exception {
	private static final long serialVersionUID = -7592543503017517730L;
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
