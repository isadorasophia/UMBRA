package com.umbra.mobModule.exceptions;

public class BadArgumentException extends Throwable{
    public  BadArgumentException() {
        super();
    }
    public  BadArgumentException(String message) {
        super(message);
    }
    public  BadArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
    public  BadArgumentException(Throwable cause) {
        super(cause);
    }
}
