package com.umbra.mobModule.mobComponent.impl;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.impl.AttCreator;
import com.umbra.mobModule.attComponent.inter.IAttManager;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.mobComponent.inter.IMobGeneric;

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
                         Hashtable<String,IAttribute> atts){
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
    private void setAtt(Double min, String name, double value, Double max){
        IAttribute novo = atts.get(name);
        if (novo == null){
        	try {
        		IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
            	factory.registerPrototype(AttCreator.class);
            	IAttManager attmanager = factory.createInstance(
            							 "<http://purl.org/NET/dcc/com.umbra.mobModule.attComponent.impl.AttCreator>");
            	novo = attmanager.create(min, name, value, max);
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        if(atts.containsKey(name)) {
            atts.remove(name);
        }
        novo.setValue(value);
        atts.put(name, novo);
    }
    public void setAtt(String type, double value){
        setAtt(null, type, value, null);
    }
    public void setAtt(String type, double value, double max){
        setAtt(null, type, value, max);
    }
    public void setAtt(double min, String type, double value){
        setAtt(min, type, value, null);
    }
    public void setAtt(double min, String name, double value, double max){
        IAttribute novo = atts.get(name);
        if (novo == null){
        	try {
        		IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
            	factory.registerPrototype(AttCreator.class);
            	IAttManager attmanager = factory.createInstance(
            							 "<http://purl.org/NET/dcc/com.umbra.mobModule.attComponent.impl.AttCreator>");
            	novo = attmanager.create(min, name, value, max);
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        if(atts.containsKey(name)) {
            atts.remove(name);
        }
        novo.setValue(value);
        atts.put(name, novo);
    }
    public boolean hasAtt(String name){
        return atts.containsKey(name);
    }
    public void putAtt(String attName, double attValue){
        IAttribute novo = null;
        try {
    		IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
        	factory.registerPrototype(AttCreator.class);
        	IAttManager attmanager = factory.createInstance(
        							 "<http://purl.org/NET/dcc/com.umbra.mobModule.attComponent.impl.AttCreator>");
        	novo = attmanager.create(attName, attValue);
        	atts.put(attName, novo);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        
    }
    public List<IAttribute> getAllAtts(){
        List<IAttribute> resp = new ArrayList<IAttribute>();
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
