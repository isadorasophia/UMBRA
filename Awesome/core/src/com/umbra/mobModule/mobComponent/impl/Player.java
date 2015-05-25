package com.umbra.mobModule.mobComponent.impl;


import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.impl.AttCreator;
import com.umbra.mobModule.attComponent.inter.IAttManager;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

public class Player extends PlayerGeneric implements IPlayer{

    private static Player instance;

    private Player(String name, String description, IPosition position, int invSize) {
        super(name, description, position, invSize);
    }
    public static Player getInstance(String name, String description, IPosition position, int invSize){
        if (instance == null) {
            instance = new Player(name, description, position, invSize);
        }
        return instance;
    }

    public double getXp() {
        if (!(hasAtt("xp")) ) {
            return 0;
        } else {
            return getAtt("xp").getValue();
        }
    }

    public void setXp(double xp) {
        if (!(hasAtt("xp"))) {
        	try {
        		IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
            	factory.registerPrototype(AttCreator.class);
            	IAttManager attmanager = factory.createInstance(
            							 "<http://purl.org/NET/dcc/com.umbra.mobModule.attComponent.impl.AttCreator>");
            	IAttribute novo = attmanager.create(0.0, "xp", xp);
            	atts.put("xp", novo);
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
            
        } else {
            atts.get("xp").setValue(xp);
        }
    }

    public int getNivel(){
        if(!(hasAtt("xp")) ){
            return 0;
        }else{
            return (int) Math.floor(Math.log10(getAtt("xp").getValue()));
        }
    }
}
