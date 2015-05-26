package com.umbra.mobModule.mobComponent.impl;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.mobComponent.inter.IMonstroGeneric;

import java.util.Hashtable;
import java.util.List;


public class MonstroGeneric extends Mob implements IMonstroGeneric {
    private int id;

    public MonstroGeneric(String name, String description, IPosition position, int id){
        super(name, description, position);
        this.id = id;
    }

    public MonstroGeneric(String name, String description, IPosition position,
                          List<IAttribute> atts, int id){
        super(name, description, position, atts);
        this.id = id;
    }

    public MonstroGeneric(String name, String description, IPosition position, Hashtable<String, IAttribute> atts, int id) {
        super(name, description, position, atts);
        this.id = id;
    }

    public Type getType(){
        Type resp =  Type.MONSTRO;
        resp.setChar(getName().charAt(0));
        return resp;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

}
