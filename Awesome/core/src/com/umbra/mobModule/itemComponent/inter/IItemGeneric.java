package com.umbra.mobModule.itemComponent.inter;

import com.umbra.mobModule.interGenerics.*;

public interface IItemGeneric extends
        IPositionable,
        IDescriptionReadable,
        INameReadable,
        ITypeReadable,
        Stringlizable
{
    public double getFindProb();
}
