package com.umbra.mobModule.enums;

import com.umbra.mobModule.modAttComponent.impl.*;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

public enum Operation {
	ADICAO(new Adder()),
    SUBTRACAO(new Subtract()),
    MULTIPLICACAO(new Multiplier()),
    DIVISAO(new Divisor());
    private IModificator modificator;
    private Operation(IModificator modificator){
        this.modificator = modificator;
    }

    /**
     * @return Retorna o modificador apropriado
     */
    public IModificator getModificator(){
        return modificator;
    }
}
