package com.umbra.mobModule.modAttComponent;

import com.umbra.mobModule.Exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.Exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.INameReadable;
import com.umbra.mobModule.attComponent.IAttribute;

public interface IModAtt extends INameReadable {
    public IAttribute modify(IAttribute src) throws CannotDoubleModifyAttributeException;
    public IAttribute unmodify() throws CannotUnmodifyWhatHasNotBeenModifiedException;
}
