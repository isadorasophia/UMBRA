package com.umbra.mobModule.modAttComponent.impl;

import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

/**
 * Classe que implementa uma operação de soma na modificação de um atributo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class Adder implements IModificator {
	private Double oldValue;
	
    public IAttribute modify(IAttribute src, double... parameter) {
    	oldValue = src.getValue();
        src.setValue(src.getValue() + parameter[0]);
        return src;
    }
    
    public IAttribute unmodify(IAttribute src) {
        src.setValue(oldValue);
        return src;
    }
    
}
