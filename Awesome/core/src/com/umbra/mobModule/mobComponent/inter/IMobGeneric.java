package com.umbra.mobModule.mobComponent.inter;

import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.interGenerics.*;


public interface IMobGeneric extends
        IPositionable,
        IDescriptionReadable,
        INameReadable,
        ITypeReadable,
        Stringlizable
{
    public IAttribute getAtt(String type);

    public void setAtt(String type, double value);
    public void setAtt(String type, double value, double max);
    public void setAtt(double min, String type, double value);
    public void setAtt(double min, String type, double value, double max);

    boolean hasAtt(String name);
}
