package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.IClonable;
import com.umbra.mobModule.IDescriptionReadable;
import com.umbra.mobModule.INameReadable;
import com.umbra.mobModule.IPositionable;
import com.umbra.mobModule.attComponent.IAttribute;


public interface IMobGeneric extends IPositionable, IDescriptionReadable, INameReadable, IClonable{

    public IAttribute getAtt(String type);
    public void setAtt(String type, double value);
    public Boolean hasAtt(String name);
    public char getChar();
    public IMobGeneric clone();
}
