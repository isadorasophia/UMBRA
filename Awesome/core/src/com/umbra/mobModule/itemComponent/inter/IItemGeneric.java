package com.umbra.mobModule.itemComponent.inter;

import com.umbra.mobModule.*;
import com.umbra.mobModule.interenum.IDescriptionReadable;
import com.umbra.mobModule.interenum.INameReadable;
import com.umbra.mobModule.interenum.IPositionable;
import com.umbra.mobModule.interenum.ITypeReadable;

public interface IItemGeneric
        extends IPositionable, IDescriptionReadable,
        INameReadable, ITypeReadable {
    public double getFindProb();
}
