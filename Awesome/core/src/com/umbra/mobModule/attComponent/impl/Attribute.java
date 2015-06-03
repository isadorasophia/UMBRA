package com.umbra.mobModule.attComponent.impl;

import com.umbra.mobModule.Margin;
import com.umbra.mobModule.attComponent.inter.IAttribute;

public class Attribute implements IAttribute  {
    private String name;
    private double value;
    private Double min = null;
    private Double max = null;

    public static final double MIN = 0;

    public Attribute(Double min, String name, double value, Double max){
        this.name = name;
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public Attribute(double min, String name, double value, double max){
        this(new Double(min), name, value, new Double(max));
    }

    public Attribute(String name, double value){
        this(null, name, value,  null);
    }

    public Attribute(String name, double value, double max){
        this(null, name, value,  max);
    }

    public Attribute(double min, String name, double value){
        this(min, name, value, null);
    }

    public String getName() {
        return name;
    }
    
    public double getValue() {
        return value;
    }
    
    public void setValue(double value) {
        boolean set = true;
        if (min != null && value < min) {
        	this.value = min;
            set = false;
        }
        if (max != null && value > max) {
        	this.value = max;
            set = false;
        }
        if (set) {
            this.value = value;
        }
    }

    public String toString(Margin m){
        String resp = "";
        resp += String.format("%s = %f", name, value);
        if(min != null){
            resp += String.format(", min = %.1f", min);
        }
        if(max != null){
            resp += String.format(", max = %.1f", max);
        }
        return m.ident(resp);
    }
    public String toString(){
        return toString(Margin.first());
    }

    public IAttribute clone() {
        return new Attribute(name, value);
    }
}
