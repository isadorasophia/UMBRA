package com.umbra.mobModule.attComponent.inter;

import com.umbra.mobModule.interGenerics.IClonable;
import com.umbra.mobModule.interGenerics.INameReadable;

public interface IAttribute extends INameReadable, IClonable<IAttribute>{
    public double getValue();
    public void setValue(double value);
}
