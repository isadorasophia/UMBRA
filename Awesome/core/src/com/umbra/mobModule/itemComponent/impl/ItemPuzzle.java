package com.umbra.mobModule.itemComponent.impl;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.itemComponent.inter.IItemPuzzle;

import java.util.ArrayList;
import java.util.List;

public class ItemPuzzle extends Item implements IItemPuzzle {
    private List<String> adjectives;

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
    	int index = adjectives.indexOf(src);
        adjectives.remove(index);
        adjectives.add(index, newAdj);
    }
    public Type getType(){
        return Type.ITEM_PUZZLE;
    }
}
