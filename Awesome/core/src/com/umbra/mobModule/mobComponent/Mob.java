package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.attComponent.Attribute;
import com.umbra.mobModule.attComponent.IAttribute;
import com.umbra.mapModule.*;

import java.util.*;


public abstract class Mob implements IMobGeneric {
    protected String name;
    protected String description;
    protected IPosition position;
    protected Hashtable<String,IAttribute> atts;


    protected Mob(String name){
        this.name = name;
        this.description = "No Description";
        this.atts = new Hashtable<String,IAttribute>();
    }
    protected Mob(String name, String description){
        this(name);
        this.description = description;
    }
    protected Mob(String name, String description, IPosition position){
        this(name, description);
        this.position = position;
    }
    protected Mob(String name, String description, IPosition position,
                  Hashtable<String,IAttribute> atts){
        this(name, description, position);
        this.atts = atts;
    }

    protected Mob(String name, String description, IPosition position,
                  List<IAttribute> atts){
        this(name, description, position);

        for(IAttribute attribute : atts){
            String attName = attribute.getName();
            double attValue = attribute.getValue();
            this.putAtt(attName, attValue);
        }
	}


    public abstract char getChar();

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
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
    public abstract IMobGeneric clone();

}
