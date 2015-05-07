package com.umbra.mobModule.itemComponent;

import mapModule.IPosition;


public class ItemIlumination extends Item implements IItemIlumination {
    private double ilumination;

    public ItemIlumination(String name, String description, double findProb,
    					   IPosition pos, double ilumination) {
        super(name, description, findProb, pos);
        this.ilumination = ilumination;
    }

    public double getIlumination() {
        return ilumination;
    }

    public void setIlumination(double ilumination) {
        this.ilumination = ilumination;
    }
}
