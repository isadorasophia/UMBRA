package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.*;
import com.umbra.mobModule.attComponent.IAttribute;


public interface IMobGeneric extends
        IPositionable,
        IDescriptionReadable,
        INameReadable,
        ITypeReadable
{
    public IAttribute getAtt(String type);

    public void setAtt(String type, double value);
    public void setAtt(String type, double value, double max);
    public void setAtt(double min, String type, double value);
    public void setAtt(double min, String type, double value, double max);

    boolean hasAtt(String name);
}
