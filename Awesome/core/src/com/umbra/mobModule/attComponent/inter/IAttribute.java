package com.umbra.mobModule.attComponent.inter;

import com.umbra.mobModule.interGenerics.IClonable;
import com.umbra.mobModule.interGenerics.INameReadable;
import com.umbra.mobModule.interGenerics.Stringlizable;

public interface IAttribute extends
        INameReadable,
        IClonable<IAttribute>,
        Stringlizable
{
    public double getValue();
    public void setValue(double value);
}
