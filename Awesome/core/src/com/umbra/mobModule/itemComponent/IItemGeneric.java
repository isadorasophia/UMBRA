package com.umbra.mobModule.itemComponent;

import com.umbra.mobModule.*;

public interface IItemGeneric
        extends IPositionable, IDescriptionReadable,
        INameReadable, IGetTypeAble  {
    public double getFindProb();
}
