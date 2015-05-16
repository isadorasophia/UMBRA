package com.umbra.mobModule.mobComponent;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.Type;
import com.umbra.mobModule.attComponent.IAttribute;

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
    public IMobGeneric clone(){
        IMobGeneric clone = new MonstroGeneric(name, description, position, atts, id);
        return clone;
    }

}
