package com.umbra.mobModule.exceptions;

public class FullInventoryException extends Exception {
    private static final long serialVersionUID = 0;
    public FullInventoryException() {
        super();
    }
    public FullInventoryException(String message) {
        super(message);
    }
    public FullInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
    public FullInventoryException(Throwable cause) {
        super(cause);
    }
}
