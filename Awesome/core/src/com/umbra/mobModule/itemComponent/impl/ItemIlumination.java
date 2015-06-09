package com.umbra.mobModule.itemComponent.impl;

import com.umbra.mapModule.inter.IPosition;
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
     * @param name : nome do item
     * @param description : descrição do item
     * @param findProb : probabilidade de ser encontrado
     * @param pos : posição
     * @param ilumination : valor da iluminação
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
