package com.umbra.Exceptions;

public class InputException extends Throwable {

    public InputException() {
        super();
    }

    public InputException(String message) {
        super(message);
    }

    public InputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputException(Throwable cause) {
        super(cause);
    }

}

