package com.umbra.mobModule.modAttComponent;


import com.umbra.mobModule.attComponent.IAttribute;

public class Addicionator implements IModificator {

    /* Throws CannotDoubleModifyAnAttribute if(src != null) */
    public IAttribute modify(IAttribute src, double... parameter) {
        src.setValue(src.getValue() + parameter[0]);
        return src;
    }
}
