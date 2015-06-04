package com.umbra.mobModule.exceptions;

public class BadArgumentException extends Exception {
	private static final long serialVersionUID = -6387658448933975334L;
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
