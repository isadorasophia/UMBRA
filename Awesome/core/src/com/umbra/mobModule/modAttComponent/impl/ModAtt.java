package com.umbra.mobModule.modAttComponent.impl;

import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.exceptions.*;
import com.umbra.mobModule.modAttComponent.inter.IModAtt;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

public class ModAtt implements IModAtt {
    private String attName;
    private IModificator operation;
    private double[] parameters;
    private IAttribute src;

    public ModAtt(String attName, IModificator operation, double ... parameter){
        this.attName = attName;
        this.operation = operation;
        parameters = parameter;
    }
    /* Throws CannotDoubleModifyAttributeException if(this.src != null)*/
    public IAttribute modify(IAttribute src) throws CannotDoubleModifyAttributeException {
        if (this.src != null) {
            throw new CannotDoubleModifyAttributeException();
        }
        IAttribute resp;
        IAttribute clone = src.clone();
        this.src = src;
        resp = operation.modify(clone, this.parameters);
        return resp;

    }
    /* Throws CannotUnmodifyWhatHasNoBeenModifiedException if(src == null)  */
    public IAttribute unmodify() throws CannotUnmodifyWhatHasNotBeenModifiedException {
        if(src == null){
            throw new CannotUnmodifyWhatHasNotBeenModifiedException();
        }
        IAttribute returnValue = src.clone();
        src = null;
        return returnValue;
    }

    public String getName() {
        return attName;
    }
}
