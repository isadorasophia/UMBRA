package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.*;
import com.umbra.mobModule.attComponent.IAttribute;


public interface IMobGeneric
        extends IPositionable, IDescriptionReadable,
        INameReadable, IGetTypeAble{

    public IAttribute getAtt(String type);
    public void setAtt(String type, double value);

    boolean hasAtt(String name);
}
