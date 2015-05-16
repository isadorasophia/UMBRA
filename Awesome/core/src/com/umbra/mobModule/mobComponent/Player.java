package com.umbra.mobModule.mobComponent;


import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.AttCreator;

public class Player extends PlayerGeneric implements IPlayer{

    public Player(String name, String description, IPosition position, int invSize) {
        super(name, description, position, invSize);
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
            atts.put("xp", AttCreator.create(0, "xp", xp));
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
