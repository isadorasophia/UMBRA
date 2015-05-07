package com.umbra.mobModule;

public class Attribute implements IAttribute {
    private String name;
    private double value;

    public Attribute(String name, double value){
        this.name = name;
        this.value = value;
    }
    public String getName(){
        return name;
    }
    public double getValue(){
        return value;
    }
    public void setValue(double value){
        this.value = value;
    }

    public IAttribute clone() {
        return new Attribute(name, value);
    }
}
