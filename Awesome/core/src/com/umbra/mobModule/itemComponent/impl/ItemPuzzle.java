package com.umbra.mobModule.itemComponent.impl;

import com.umbra.mapModule.inter.IPosition;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.itemComponent.inter.IItemPuzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface que contém métodos de um item do tipo puzzle que será usado no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class ItemPuzzle extends Item implements IItemPuzzle {
    private List<String> adjectives;

    /**
     * Construtor padrão do item puzzle
     * @param name : nome do item
     * @param description : descrição do item
     * @param findProb : probabilidade de ser encontrado
     * @param pos : posição
     */
    public ItemPuzzle(String name, String description, double findProb, IPosition pos){
        super(name, description, findProb, pos);
        adjectives = new ArrayList<String>();
    }

    public List<String> getAdjectives() {
        return adjectives;
    }

    public void newAdjective(String newAdj) {
        adjectives.add(adjectives.size(), newAdj);
    }

    public void modAdj(String src, String newAdj) {
    	if (adjectives.contains(src)) {
    		int index = adjectives.indexOf(src);
        	adjectives.remove(index);
        	adjectives.add(index, newAdj);
    	} else {
    		newAdjective(newAdj);
    	}
    }
    
    public Type getType(){
        return Type.ITEM_PUZZLE;
    }
}
