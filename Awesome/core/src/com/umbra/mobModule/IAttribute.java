package com.umbra.mobModule;

public interface IAttribute {
    public String getName();
    public double getValue();
    public void setValue(double value);
    public IAttribute clone();
}
