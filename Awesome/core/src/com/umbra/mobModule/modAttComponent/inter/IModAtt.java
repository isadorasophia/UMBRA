package com.umbra.mobModule.modAttComponent.inter;

import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.interGenerics.INameReadable;
import com.umbra.mobModule.interGenerics.Stringlizable;

public interface IModAtt extends
        INameReadable,
        Stringlizable
{
    public IAttribute modify(IAttribute src) throws CannotDoubleModifyAttributeException;
    public IAttribute unmodify() throws CannotUnmodifyWhatHasNotBeenModifiedException;
}
