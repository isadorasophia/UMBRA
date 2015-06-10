package com.umbra.Exceptions;

import com.umbra.Exceptions.InputException;

public class UnknownInputException extends InputException {

    public UnknownInputException() {
        super("That\'s an invalid command." + '\n');
    }

    public UnknownInputException(Throwable cause) {
        super("That\'s an invalid command." + '\n', cause);
    }

}
