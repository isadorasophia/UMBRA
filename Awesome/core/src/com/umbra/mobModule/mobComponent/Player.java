package com.umbra.mobModule.mobComponent;


import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.Attribute;
import com.umbra.mobModule.attComponent.IAttribute;
import com.umbra.mobModule.itemComponent.IItem;

import java.util.Hashtable;
import java.util.List;

public class Player extends PlayerGeneric implements IPlayer{

    public Player(String name, String description, IPosition position) {
        super(name, description, position);
    }

    public Player(String name, String description, IPosition position, List<IAttribute> atts) {
        super(name, description, position, atts);
    }

    public Player(String name, String description, IPosition position, Hashtable<String, IAttribute> atts) {
        super(name, description, position, atts);
    }

    public Player(String name, String description, IPosition position, Hashtable<String, IAttribute> atts, List<IItem> items, int size) {
        super(name, description, position, atts, items, size);
    }

    public Player(String name, String description, IPosition position, List<IAttribute> atts, List<IItem> items, int size) {
        super(name, description, position, atts, items, size);
    }

    public Player(String name, String description, IPosition position, Hashtable<String, IAttribute> atts, IInventory inventory) {
        super(name, description, position, atts, inventory);
    }


    public double getXp() {
        if(atts != null || ! (hasAtt("xp")) ){
            return 0;
        }else{
            return getAtt("xp").getValue();
        }
    }

    public void setXp(double xp) {
        if(atts != null || ! (hasAtt("xp")) ){
            atts.put("xp", new Attribute("xp", xp));
        }else{
            atts.get("xp").setValue(xp);
        }
    }

    public double maxXp() {
        return 0;
    }

    public int getNivel(){
        if(atts != null || ! (hasAtt("xp")) ){
            return 0;
        }else{
            return (int) Math.floor(Math.log10(getAtt("xp").getValue()));
        }
    }
}
