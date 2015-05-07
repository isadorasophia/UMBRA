package com.umbra.mobModule.itemComponent;

import com.umbra.mapModule.IPosition;


public interface IItem {
    public String getName();
    public String getDescription();
    public double getFindProb();
    public IPosition getPosition();
}
