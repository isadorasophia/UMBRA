package com.umbra.dbModule.exceptions;

/**
 * Exceção para quando não houver o método na classe
 * 
 * @author Henrique Noronha Facioli
 * @author Thiago Silva de Farias
 *
 */

public class NoMethod extends Exception {
	private static final long serialVersionUID = 3863010501019562695L;

	public NoMethod() {
		super();
	}

	public NoMethod(String message) {
		super(message);
	}
}
