package com.umbra.mobModule.itemComponent.impl;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.Margin;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.itemComponent.inter.IItem;

/**
 * Classe abstrata que representa um item que será usado em um jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public abstract class Item implements IItem{
    protected String name;
    protected String description;
    protected double findProb;
    protected IPosition pos;

    /**
     * Construtor padrão do item
     * @param name : nome do item
     * @param description : descrição
     * @param findProb : probabilidade de ser encontrado
     * @param pos : posição
     */
    public Item(String name, String description, double findProb, IPosition pos){
        this.name = name;
        this.description = description;
        this.findProb = findProb;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getFindProb(){
        return findProb;
    }
    
    public IPosition getPosition(){
        return pos;
    }
    
    public void setPosition(IPosition pos){
        this.pos = pos;
    }
    
    public abstract Type getType();
    
    public String toString(Margin m){
        Type t = getType();
        String resp = "";
        resp += m.ident(String.format("Item(%c): %s", t.getChar(), t.getDescription()));
        resp += m.ident(String.format("name = %s", getName()));
        resp += m.ident(String.format("description = %s", getDescription()));
        resp += m.ident(String.format("findProb = %f", getFindProb()));
        return resp;
    }
    
    public String toString(){
        return toString(Margin.first());
    }
    
}
