package com.umbra.mobModule.modAttComponent.inter;

import com.umbra.mobModule.attComponent.inter.IAttribute;

public interface IModificator {
    public IAttribute modify(IAttribute src, double ... parameters);
}
