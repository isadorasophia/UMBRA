package com.umbra.mobModule.mobComponent;

import mapModule.*;
import mobModule.*;

import java.util.Hashtable;
import java.util.List;


public abstract class Mob implements IMob{
    protected IPosition position;
    protected Hashtable<String,IAttribute> atts;
    protected String name;

    protected Mob(String name, IPosition position,
                  Hashtable<String,IAttribute> atts){
        this.name = name;
        this.position = position;
        this.atts = atts;
    }

    protected Mob(String name, IPosition position,
                  List<IAttribute> atts){
        this.name = name;
        this.position = position;
        this.atts = new Hashtable<String, IAttribute>();
        for(IAttribute attribute : atts){
            String attName = attribute.getName();
            double attValue = attribute.getValue();
            this.putAtt(attName, attValue);
        }
	}
    public IAttribute getAtt(String type){
        return atts.get(type);
    }
    public void setAtt(String type, double value){
        IAttribute novo = atts.get(type);
    	atts.remove(type);
    	novo.setValue(value);
        atts.put(type, novo);
    }
    public Boolean hasAtt(String name){
        return atts.containsKey(name);
    }
    public void putAtt(String attName, double attValue){
        IAttribute novo = new Attribute(attName, attValue);
        atts.put(attName, novo);
    }
    public IPosition getPosition(){
       return position;
    }
    public void setPosition(IPosition position){
        this.position = position;
    }
    public abstract IMob clone();

}
