package com.umbra.mobModule.itemComponent.impl;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.Margin;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.itemComponent.inter.IItem;

public abstract class Item implements IItem{
    protected String name;
    protected String description;
    protected double findProb;
    protected IPosition pos;

    public Item(String name, String description, double findProb, IPosition pos){
        this.name = name;
        this.description = description;
        this.findProb = findProb;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getFindProb(){
        return findProb;
    }
    public IPosition getPosition(){
        return pos;
    }
    public void setPosition(IPosition pos){
        this.pos = pos;
    }
    public abstract Type getType();
    public String toString(Margin m){
        String resp = "";
        Type t = getType();
        resp += m.ident(String.format("Item(%c): %s"));
        resp += m.ident(getName());
        resp += m.ident(getDescription());
        resp += m.ident(String.format("%f", getFindProb()));
        return resp;
    }
    public String toString(){
        return toString(Margin.first());
    }
}
