package com.umbra.mobModule.modAttComponent;

import com.umbra.mobModule.attComponent.IAttribute;

public interface IModificator {
    public IAttribute modify(IAttribute src, double ... parameters);
}
