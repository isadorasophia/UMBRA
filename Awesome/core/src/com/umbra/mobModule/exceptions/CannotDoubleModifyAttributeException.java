package com.umbra.mobModule.exceptions;

/**
 * Exceção disparada quando se tenta modificar o player com
 * o mesmo item duas vezes seguidas, com o mesmo modificador
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
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
