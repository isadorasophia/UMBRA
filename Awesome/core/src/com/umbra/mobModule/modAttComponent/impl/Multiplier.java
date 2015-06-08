package com.umbra.mobModule.modAttComponent.impl;

import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

/**
 * Classe que implementa uma operação de multiplicação na modificação de atributo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class Multiplier implements IModificator {
	
    public IAttribute modify(IAttribute src, double... parameter) {
        src.setValue(src.getValue() * parameter[0]);
        return src;
    }
    public IAttribute unmodify(IAttribute src, double... parameter) {
        src.setValue(src.getValue() / parameter[0]);
        return src;
    }
}
