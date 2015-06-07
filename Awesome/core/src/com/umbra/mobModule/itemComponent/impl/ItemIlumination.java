package com.umbra.mobModule.itemComponent.impl;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.itemComponent.inter.IItemIlumination;

/**
 * Classe que implementa um item de iluminação que será usado no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class ItemIlumination extends Item implements IItemIlumination {
    private double ilumination;

    /**
     * Construtor do item de iluminação
     * @param name
     * @param description
     * @param findProb
     * @param pos
     * @param ilumination
     */
    public ItemIlumination(String name, String description, double findProb,
    					   IPosition pos, double ilumination) {
        super(name, description, findProb, pos);
        this.ilumination = ilumination;
    }

    public double getIlumination() {
        return ilumination;
    }

    public void setIlumination(double ilumination) {
        this.ilumination = ilumination;
    }

    public Type getType(){
        return Type.ITEM_ILUMINATION;
    }
}
