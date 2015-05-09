package com.umbra.mobModule.mobComponent;


import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.IAttribute;

import java.util.Hashtable;
import java.util.List;

public abstract class Mob extends MobGeneric implements IMob{

    protected Mob(String name, IPosition position) {
        super(name, position);
    }

    protected Mob(String name, String description, IPosition position) {
        super(name, description, position);
    }

    protected Mob(String name, String description, IPosition position, Hashtable<String, IAttribute> atts) {
        super(name, description, position, atts);
    }

    protected Mob(String name, String description, IPosition position, List<IAttribute> atts) {
        super(name, description, position, atts);
    }

    public int getNivel(){
        if(atts != null || ! (hasAtt("xp")) ){
            return 0;
        }else{
            return (int) Math.floor(Math.log10(getAtt("xp").getValue()));
        }
    }

    public abstract char getChar();

    public abstract IMobGeneric clone();
}
