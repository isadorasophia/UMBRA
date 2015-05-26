package com.umbra.mobModule.mobComponent.impl;


import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.mobComponent.inter.IMob;

import java.util.Hashtable;
import java.util.List;

public abstract class Mob extends MobGeneric implements IMob{

    protected Mob(String name, String description, IPosition position) {
        super(name, description, position);
    }

    protected Mob(String name, String description, IPosition position, Hashtable<String, IAttribute> atts) {
        super(name, description, position, atts);
    }

    protected Mob(String name, String description, IPosition position, List<IAttribute> atts) {
        super(name, description, position, atts);
    }

    public boolean dead(){
        return this.getAtt("hp").getValue() == 0;
    }

    public abstract Type getType();

    public void attsPrint(){
        for(IAttribute att : getAllAtts()){
            System.out.println(att.getName() + " : " + att.getValue());
        }
        System.out.println("\n");
    }

    public char getChar(){
        return getType().getChar();
    }
}
