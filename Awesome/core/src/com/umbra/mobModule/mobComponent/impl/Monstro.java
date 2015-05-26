package com.umbra.mobModule.mobComponent.impl;


import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.mobComponent.inter.IMonstro;

import java.util.Hashtable;
import java.util.List;

public class Monstro extends MonstroGeneric implements IMonstro{

    public Monstro(String name, String description, IPosition position, int id) {
        super(name, description, position, id);
    }

    public Monstro(String name, String description, IPosition position, List<IAttribute> atts, int id) {
        super(name, description, position, atts, id);
    }

    public Monstro(String name, String description, IPosition position, Hashtable<String, IAttribute> atts, int id) {
        super(name, description, position, atts, id);
    }

}
