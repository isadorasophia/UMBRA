package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.attComponent.IAttribute;
import com.umbra.mapModule.IPosition;

import java.util.*;


public class Monstro extends Mob implements IMonstro {
    private int id;
    public Monstro(String name){
        super(name);
    }

    public Monstro(String name, String description, int id){
        super(name, description);
        this.id = id;
    }

    public Monstro(String name, String description, IPosition position, int id){
        super(name, description, position);
        this.id = id;
    }

    public Monstro(String name, String description, IPosition position,
                   List<IAttribute> atts, int id){
        super(name, description, position, atts);
        this.id = id;
    }

    public Monstro(String name, String description, IPosition position, Hashtable<String, IAttribute> atts, int id) {
        super(name, description, position, atts);
        this.id = id;
    }

    public char getChar(){
        return getName().charAt(0);
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public IMobGeneric clone(){
        IMobGeneric clone = new Monstro(name, description, position, atts, id);
        return clone;
    }

}
