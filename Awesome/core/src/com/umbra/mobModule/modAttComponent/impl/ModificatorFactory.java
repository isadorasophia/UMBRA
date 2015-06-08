package com.umbra.mobModule.modAttComponent.impl;

import com.umbra.mobModule.enums.Operation;
import com.umbra.mobModule.exceptions.BadArgumentException;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

/**
 * Classe com um método estático que cria uma
 * operação de um modificador de atributo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class ModificatorFactory {
	
	/**
	 * Cria uma operação de acordo com o enumerado que for passado
	 * @param type
	 * @param parameter
	 * @return
	 * @throws BadArgumentException
	 */
	public static IModificator operationCreator(Operation type, double ... parameter) throws BadArgumentException {
		IModificator novo = null;
		
		if (type == Operation.DIVISAO) {
			for (double p : parameter) {
				if (p == 0) {
					throw new BadArgumentException("You've tried to create an ByZeroDivider");
				}
			}
		}
		
		if (type == Operation.ADICAO) {
			novo = new Adder();
		} else if (type == Operation.SUBTRACAO) {
			novo = new Subtract();
		} else if (type == Operation.MULTIPLICACAO) {
			novo = new Multiplier();
		} else if (type == Operation.DIVISAO) {
			novo = new Divisor();
		}
		
		return novo;
	}
}
