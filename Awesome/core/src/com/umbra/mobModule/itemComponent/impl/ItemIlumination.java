package com.umbra.mobModule.itemComponent.impl;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.interenum.Type;
import com.umbra.mobModule.itemComponent.inter.IItemIlumination;


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

    public Type getType(){
        return Type.ITEM_ILUMINATION;
    }
}
