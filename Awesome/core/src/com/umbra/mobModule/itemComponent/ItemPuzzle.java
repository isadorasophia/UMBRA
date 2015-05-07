package com.umbra.mobModule.itemComponent;

import mapModule.IPosition;

import java.util.List;

public class ItemPuzzle extends Item implements IItemPuzzle {
    private List<String> adjectives;

    public ItemPuzzle(String name, String description,
                      double findProb, IPosition pos){
        super(name, description, findProb, pos);
    }
    public List<String> getAdjectives() {
        return adjectives;
    }

    public void newAdjective(String newAdj) {
        adjectives.add(adjectives.size(), newAdj);
    }

    public void modAdj(String src, String newAdj) {
        adjectives.remove(adjectives.indexOf(src));
        adjectives.add(adjectives.indexOf(src), newAdj);
    }
}
