package com.umbra.mobModule.modAttComponent.impl;

import com.umbra.mobModule.enums.Operation;
import com.umbra.mobModule.exceptions.BadArgumentException;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

public class ModificatorFactory {
	public static IModificator operationCreator(Operation type, double parameter) throws BadArgumentException {
		IModificator novo = null;
		if(type == Operation.DIVISAO && parameter == 0){
            throw new BadArgumentException("You've tried to create an ByZeroDivider");
        }
		novo = type.getModificator();
		return novo;
	}
}
