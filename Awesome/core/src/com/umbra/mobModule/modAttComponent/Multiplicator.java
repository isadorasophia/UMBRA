package com.umbra.mobModule.modAttComponent;


import com.umbra.mobModule.attComponent.IAttribute;

public class Multiplicator implements IModificator {
    /* Throws BadArgumentException if(parameter[0] == 0) */
    public IAttribute modify(IAttribute src, double... parameter) {
        src.setValue(src.getValue() * parameter[0]);
        return src;
    }
}
