package com.umbra.vultoModule.Exceptions;

import com.umbra.vultoModule.Exceptions.InputException;

public class UnknownInputException extends InputException {

    public UnknownInputException() {
        super(" I don't understand this command :");
    }

    public UnknownInputException(Throwable cause) {
        super(" I don't understand this command :",cause);
    }
}
