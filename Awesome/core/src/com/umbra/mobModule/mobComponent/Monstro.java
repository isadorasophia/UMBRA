package com.umbra.mobModule.mobComponent;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.*;

import java.util.*;


public class Monstro extends Mob implements IMonstro {
    private int id;
    public Monstro(String name, IPosition position,
                   List<IAttribute> atts, int id){
        super(name, position, atts);
        this.id = id;
    }

    public Monstro(String name, IPosition position, Hashtable<String, IAttribute> atts, int id) {
        super(name, position, atts);
        this.id = id;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public IMob clone(){
        IMob clone = new Monstro(name, position, atts, id);
        return clone;
    }

}
