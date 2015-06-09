package com.umbra.mobModule.exceptions;

/**
 * Exceção que é disparada quando se tenta adicionar um item que já está no inventário
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class SameItemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1518437214593829876L;
	public SameItemException() {
        super();
    }
    public SameItemException(String message) {
        super(message);
    }
    public SameItemException(String message, Throwable cause) {
        super(message, cause);
    }
    public SameItemException(Throwable cause) {
        super(cause);
    }
}
