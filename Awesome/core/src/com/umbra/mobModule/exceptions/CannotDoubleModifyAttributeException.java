package com.umbra.mobModule.exceptions;

/**
 * Created by racoci on 14/05/15.
 */
public class CannotDoubleModifyAttributeException extends BadAttributeModificationException {
    public CannotDoubleModifyAttributeException() {
        super();
    }
    public CannotDoubleModifyAttributeException(String message) {
        super(message);
    }
    public CannotDoubleModifyAttributeException(String message, Throwable cause) {
        super(message, cause);
    }
    public CannotDoubleModifyAttributeException(Throwable cause) {
        super(cause);
    }
}
