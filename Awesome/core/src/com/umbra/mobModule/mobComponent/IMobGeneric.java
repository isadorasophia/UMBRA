package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.IClonable;
import com.umbra.mobModule.IDescriptionReadable;
import com.umbra.mobModule.INameReadable;
import com.umbra.mobModule.IPositionable;
import com.umbra.mobModule.attComponent.IAttribute;


public interface IMobGeneric extends IPositionable, IDescriptionReadable, INameReadable, IClonable<IMobGeneric>{

    public IAttribute getAtt(String type);
    public void setAtt(String type, double value);
    public char getChar();

    boolean hasAtt(String name);
}
