package com.umbra.mobModule.itemComponent;

import com.umbra.mapModule.IPosition;


public class ItemFactory{

    IItemBattle instantiate(String name, String description, double findProb, IPosition pos){
        return new ItemBattle(name, description, findProb, pos);
    }
    IItemPuzzle instantiateP(String name, String description, double findProb, IPosition pos){
        return new ItemPuzzle(name, description, findProb, pos);
    }
    IItemIlumination instantiate(String name, String description, double findProb, IPosition pos, double ilumination){
        return new ItemIlumination(name, description, findProb, pos, ilumination);
    }
}