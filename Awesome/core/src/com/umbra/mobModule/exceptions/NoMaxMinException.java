package com.umbra.mobModule.exceptions;

/**
 * Exceção chamada quando se tenta pegar o valor mínimo ou máximo
 * de um atributo mas esse valor não existe, é null
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class NoMaxMinException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7979300355259727725L;
	public NoMaxMinException() {
        super();
    }
    public NoMaxMinException(String message) {
        super(message);
    }
    public NoMaxMinException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoMaxMinException(Throwable cause) {
        super(cause);
    }
}
