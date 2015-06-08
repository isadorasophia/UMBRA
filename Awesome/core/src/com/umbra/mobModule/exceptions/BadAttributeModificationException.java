package com.umbra.mobModule.exceptions;

/**
 * Generalização das exceções quando se tenta modificar ou
 * desmodificar o player e algo dá errado
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class BadAttributeModificationException extends Exception {
	private static final long serialVersionUID = -1164578061017317459L;
	public BadAttributeModificationException() {
        super();
    }
    public BadAttributeModificationException(String message) {
        super(message);
    }
    public BadAttributeModificationException(String message, Throwable cause) {
        super(message, cause);
    }
    public BadAttributeModificationException(Throwable cause) {
        super(cause);
    }
}
