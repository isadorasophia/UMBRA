package com.umbra.mobModule.modAttComponent.inter;

import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.interenum.INameReadable;

public interface IModAtt extends INameReadable {
    public IAttribute modify(IAttribute src) throws CannotDoubleModifyAttributeException;
    public IAttribute unmodify() throws CannotUnmodifyWhatHasNotBeenModifiedException;
}
