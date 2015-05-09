package com.umbra.mobModule.itemComponent;

import com.umbra.mapModule.IPosition;

public class Item implements IItem{
    protected String name;
    protected String description;
    protected double findProb;
    protected IPosition pos;

    public Item(String name){
        this.name = name;
    }

    public Item(String name, String description,
                double findProb, IPosition pos){
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
}
