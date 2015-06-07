package com.umbra.mobModule.mobComponent.impl;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.Margin;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.itemComponent.inter.IItem;
import com.umbra.mobModule.mobComponent.inter.IMonstroGeneric;

import java.util.Hashtable;
import java.util.List;

/**
 * Classe que representa um monstro genérico que pode ser extendido
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class MonstroGeneric extends Mob implements IMonstroGeneric {
    private int id;

    /**
     * Construtor padrão do monstro
     * @param name
     * @param description
     * @param position
     * @param id
     */
    public MonstroGeneric(String name, String description, IPosition position, int id){
        super(name, description, position);
        this.id = id;
    }

    /**
     * Construtor que recebe uma List de atributos
     * @param name
     * @param description
     * @param position
     * @param atts
     * @param id
     */
    public MonstroGeneric(String name, String description, IPosition position,
                          List<IAttribute> atts, int id){
        super(name, description, position, atts);
        this.id = id;
    }

    /**
     * Construtor que recebe uma Hashtable com os atributos
     * @param name
     * @param description
     * @param position
     * @param atts
     * @param id
     */
    public MonstroGeneric(String name, String description, IPosition position, Hashtable<String, IAttribute> atts, int id) {
        super(name, description, position, atts);
        this.id = id;
    }

    public Type getType(){
        Type resp = Type.MONSTRO;
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
