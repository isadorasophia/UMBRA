package com.umbra.mobModule.modAttComponent.impl;

import com.umbra.mobModule.enums.Operation;
import com.umbra.mobModule.exceptions.BadArgumentException;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

public class ModificatorFactory {
	public static IModificator operationCreator(Operation type, double parameter) throws BadArgumentException {
		IModificator novo = null;
		
		if (type == Operation.ADICAO) {
			novo = new Adder();
		} else if (type == Operation.SUBTRACAO) {
			novo = new Subtract();
		} else if (type == Operation.MULTIPLICACAO) {
			novo = new Multiplier();
		} else if (type == Operation.DIVISAO) {
			novo = new Divisor();
			if (parameter == 0) {
				throw new BadArgumentException("You've tried to create an ByZeroDivider");
			}
		}
		
		return novo;
	}
}
