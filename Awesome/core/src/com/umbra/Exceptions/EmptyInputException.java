package com.umbra.Exceptions;

public class EmptyInputException extends InputException {

    public EmptyInputException() {
        super("Choose an action :");
    }

    public EmptyInputException(Throwable cause) {
        super("Choose an action :",cause);
    }
}
