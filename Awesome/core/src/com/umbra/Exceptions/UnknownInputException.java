package com.umbra.Exceptions;

import com.umbra.Exceptions.InputException;

public class UnknownInputException extends InputException {

    public UnknownInputException() {
        super(" I don't understand this command :");
    }

    public UnknownInputException(Throwable cause) {
        super(" I don't understand this command :",cause);
    }
}
