package com.umbra.mobModule.itemComponent;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.Type;


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
