package com.umbra.mobModule.attComponent;

import com.umbra.mobModule.*;

public interface IAttribute extends INameReadable, IClonable{
    public double getValue();
    public void setValue(double value);
}
