package com.umbra.mobModule.exceptions;

/**
 * Exceção disparada quando se tenta desmodificar o player
 * sem tem modificado com aquele item ainda
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

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
