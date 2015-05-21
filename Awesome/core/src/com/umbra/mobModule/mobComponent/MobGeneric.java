package com.umbra.mobModule.mobComponent;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.Type;
import com.umbra.mobModule.attComponent.AttCreator;
import com.umbra.mobModule.attComponent.IAttribute;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public abstract class MobGeneric implements IMobGeneric {
    protected String name;
    protected String description;
    protected IPosition position;
    protected Hashtable<String,IAttribute> atts;

    protected MobGeneric(String name, String description, IPosition position){
        this.name = name;
        this.description = description;
        this.position = position;
        this.atts = new Hashtable<String,IAttribute>();
    }
    protected MobGeneric(String name, String description, IPosition position,
                         Hashtable<String, IAttribute> atts){
        this(name, description, position);
        this.atts = atts;
    }

    protected MobGeneric(String name, String description, IPosition position,
                         List<IAttribute> atts){
        this(name, description, position);

        for(IAttribute attribute : atts){
            String attName = attribute.getName();
            double attValue = attribute.getValue();
            this.putAtt(attName, attValue);
        }
	}


    public abstract Type getType();

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

    public IAttribute getAtt(String name){
        IAttribute resp = atts.get(name);
        if(resp == null){
            setAtt(name, 0);
            resp = atts.get(name);
        }
        return resp;
    }
    public void setAtt(String type, double value){
        IAttribute novo = atts.get(type);
        if(novo == null){
            novo = AttCreator.create(type, value);
        }
    	atts.remove(type);
    	novo.setValue(value);
        atts.put(type, novo);
    }
    public boolean hasAtt(String name){
        return atts.containsKey(name);
    }
    public void putAtt(String attName, double attValue){
        IAttribute novo = AttCreator.create(attName, attValue);
        atts.put(attName, novo);
    }
    public List<IAttribute> getAllAtts(){
        List<IAttribute> resp = new ArrayList<>();
        for(String att_name : atts.keySet()){
            resp.add(atts.get(att_name));
        }
        return resp;
    }

    public IPosition getPosition(){
       return position;
    }
    public void setPosition(IPosition position){
        this.position = position;
    }

}
