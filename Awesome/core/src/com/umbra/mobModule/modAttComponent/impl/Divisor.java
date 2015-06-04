package com.umbra.mobModule.modAttComponent.impl;

import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

public class Divisor implements IModificator {
	
	public IAttribute modify(IAttribute src, double... parameter) {
        src.setValue(src.getValue() / parameter[0]);
        return src;
    }

    public IAttribute unmodify(IAttribute src, double... parameter) {
        src.setValue(src.getValue() * parameter[0]);
        return src;
    }

}
