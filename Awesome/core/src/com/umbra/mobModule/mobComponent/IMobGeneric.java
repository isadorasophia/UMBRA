package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.attComponent.IAttribute;
import com.umbra.mapModule.IPosition;


public interface IMobGeneric {
    public String getName();
    public IAttribute getAtt(String type);
    public String getDescription();
    public void setAtt(String type, double value);
    public void putAtt(String attName, double attValue);
    public Boolean hasAtt(String name);
    public char getChar();
    public IPosition getPosition();
    public void setPosition(IPosition position);

    public IMobGeneric clone();
}
