package com.umbra.mobModule.mobComponent;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.IFactory;
import com.umbra.mobModule.attComponent.*;
import com.umbra.mobModule.itemComponent.IItem;

import java.util.*;

public class PlayerInstantiatior implements IFactory<IPlayerGeneric> {

    public static final Integer INITIAL_SIZE = 10;

    /* Incompleto*/
    private static Hashtable<String,IAttribute> playerAtts(){

        Hashtable<String,IAttribute> resp = new Hashtable<>();

        return resp;

    }


    public IPlayerGeneric instantiate(String name, String description,  IPosition position){

        Hashtable<String,IAttribute> atts = playerAtts();


        IPlayerGeneric resp = new Player(name,description,position,atts, new ArrayList<IItem>(), INITIAL_SIZE);

        return resp;


    }

    public IPlayerGeneric instantiate(String subtype, Object... parameter) {
        return instantiate((String) parameter[0], (String) parameter[1],  (IPosition) parameter[2]);
    }
}
