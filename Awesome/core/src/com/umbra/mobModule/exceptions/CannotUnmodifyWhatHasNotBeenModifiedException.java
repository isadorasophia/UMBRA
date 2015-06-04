package com.umbra.mobModule.exceptions;


public class CannotUnmodifyWhatHasNotBeenModifiedException extends BadAttributeModificationException {
	private static final long serialVersionUID = 4784126258877927469L;
	public CannotUnmodifyWhatHasNotBeenModifiedException() {
        super();
    }
    public CannotUnmodifyWhatHasNotBeenModifiedException(String message) {
        super(message);
    }
    public CannotUnmodifyWhatHasNotBeenModifiedException(String message, Throwable cause) {
        super(message, cause);
    }
    public CannotUnmodifyWhatHasNotBeenModifiedException(Throwable cause) {
        super(cause);
    }

}
