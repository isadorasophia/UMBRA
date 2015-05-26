package com.umbra.mobModule.itemComponent.inter;

import com.umbra.mobModule.interGenerics.IDescriptionReadable;
import com.umbra.mobModule.interGenerics.INameReadable;
import com.umbra.mobModule.interGenerics.IPositionable;
import com.umbra.mobModule.interGenerics.ITypeReadable;

public interface IItemGeneric
        extends IPositionable, IDescriptionReadable,
        INameReadable, ITypeReadable {
    public double getFindProb();
}
