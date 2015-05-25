package com.umbra.mobModule.attComponent.inter;

import com.umbra.mobModule.*;
import com.umbra.mobModule.interenum.IClonable;
import com.umbra.mobModule.interenum.INameReadable;

public interface IAttribute extends INameReadable, IClonable<IAttribute>{
    public double getValue();
    public void setValue(double value);
}
