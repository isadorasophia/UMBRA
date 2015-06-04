package com.umbra.mobModule.exceptions;

/**
 * Created by racoci on 14/05/15.
 */
public class CannotDoubleModifyAttributeException extends BadAttributeModificationException {
	private static final long serialVersionUID = -2234424025970134333L;
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
