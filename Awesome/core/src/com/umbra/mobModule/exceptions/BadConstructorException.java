package com.umbra.mobModule.exceptions;

/**
 * Exceção lançada quando se tenta instanciar o player em uma fábrica
 * de monstro ou o monstro no instanciador de player
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class BadConstructorException extends Exception {
	private static final long serialVersionUID = -7592543503017517730L;
	public BadConstructorException() {
        super();
    }
    public BadConstructorException(String message) {
        super(message);
    }
    public BadConstructorException(String message, Throwable cause) {
        super(message, cause);
    }
    public BadConstructorException(Throwable cause) {
        super(cause);
    }
}
