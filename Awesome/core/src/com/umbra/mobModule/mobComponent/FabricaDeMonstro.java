package com.umbra.mobModule.mobComponent;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.IFactory;
import com.umbra.mobModule.attComponent.IAttribute;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class FabricaDeMonstro implements IFactory<IMonstroGeneric>{
    private int id;
    public FabricaDeMonstro(){
        id = 0;

    }
    private static List monster(int id, int nivel){
        List resp = new ArrayList(3);

        String name = "Monstro";
        String description = "Cruel";
        Hashtable<String,IAttribute> atts = new Hashtable<>();



        resp.add(0, name);
        resp.add(1, description);
        resp.add(2, atts);

        return resp;

    }

    /* Incompleto*/
    public IMonstroGeneric instantiate(int nivel, IPosition position){
        String name = (String) monster(id, nivel).get(0);
        String description = (String) monster(id, nivel).get(1);
        Hashtable<String,IAttribute> atts = (Hashtable<String,IAttribute>) monster(id, nivel).get(2);


        IMonstroGeneric resp = new Monstro(name, description, position, atts, id);

        id++;

        return resp;
    }


    public IMonstroGeneric instantiate(String subtype, Object... parameter) {
        return instantiate((int) parameter[0], (IPosition)parameter[1]);
    }
}
